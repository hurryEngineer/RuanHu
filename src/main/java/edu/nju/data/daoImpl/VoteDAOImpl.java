package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.VoteDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.Vote;
import edu.nju.data.util.VoteType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ss14 on 2016/7/14.
 */
@Repository
@Transactional
public class VoteDAOImpl implements VoteDAO {
    @Autowired
    BaseDAO baseDAO;
    @PersistenceContext
    EntityManager em;

    private static String tableName = "Vote";

    @Override
    public void save(Vote vote) {

        vote.setId(null);
        baseDAO.insert(vote);

    }

    @Override
    public int vote(Vote vote) {
        Query query = em.createQuery
                ("from Vote v where v.authorId = ?1 and  ( v.answerId =?2 or v.questionId = ?3)");
        query.setParameter(1,vote.getAuthorId());
        query.setParameter(2,vote.getAnswerId());
        query.setParameter(3,vote.getQuestionId());
        List<Vote> resultList = query.getResultList();
        int result = getVoteCount(vote);
        /**
         * 该用户从未对该问题或者答案做出Vote
         */
        if(resultList==null){
             System.err.println("Vote！！！！");
             save(vote);
            if(vote.getVoteType()==VoteType.up)
            {
                result++;

            }else{
                result--;
            }
        }else if(resultList.size()==0){

            System.err.println("Vote！！！！");
            save(vote);
            if(vote.getVoteType()==VoteType.up)
            {
                result++;

            }else{
                result--;
            }

        }else if(resultList.size()>=1){
            /**
             * 重复Vote,取消赞
             */
            if(vote.getVoteType()==resultList.get(0).getVoteType()){
                System.out.println();
                System.err.println("重复操作,取消赞！！！！");
                baseDAO.delete(Vote.class,resultList.get(0).getId());
                if(vote.getVoteType()==VoteType.up){
                    result--;
                }else{
                    result++;
                }

            }else{
                System.err.println("改变操作！！！！");
                baseDAO.delete(Vote.class , resultList.get(0).getId());
                save(vote);
                if(vote.getVoteType()==VoteType.up){
                    result+=2;
                }else{
                    result-=2;
                }

            }
        }


        System.err.println("votecount : "+result);
        return result;
    }

    @Override
    public int hasVoteQuestion(long userId, long questionId) {
        Query query = em.createQuery
                (" from Vote v where v.authorId = ?1 and v.questionId = ?2 ");
        query.setParameter(1,userId);
        query.setParameter(2,questionId);
        List<Vote> resultList = query.getResultList();
        if(resultList==null){
            return 0;
        }else if(resultList.size()==0){
            return  0;
        }else{
            if(resultList.get(0).getVoteType()==VoteType.up){
                return 1;
            }else{
                return -1;
            }
        }
    }

    @Override
    public int hasVoteAnswer(long userId, long answerId) {
        Query query = em.createQuery
                (" from Vote v where v.authorId = ?1 and v.answerId = ?2 ");
        query.setParameter(1,userId);
        query.setParameter(2,answerId);
        List<Vote> resultList = query.getResultList();
        if(resultList==null){
            return 0;
        }else if(resultList.size()==0){
            return  0;
        }else{
            if(resultList.get(0).getVoteType()==VoteType.up){
                return 1;
            }else{
                return -1;
            }
        }

    }



    private int getVoteCount(Vote vote){
        if(vote.getQuestionId()!=null){
            Query query = em.createQuery
                    (" from Question where id = ?1");
            query.setParameter(1,vote.getQuestionId());
            Question question = (Question) query.getSingleResult();
            return question.getVoteCount();
        }else{
            Query query = em.createQuery
                    (" from Answer where id = ?1");
            query.setParameter(1,vote.getAnswerId());
            Answer answer = (Answer) query.getSingleResult();
            return answer.getVoteCount();
        }

    }
}
