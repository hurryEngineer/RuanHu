package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.VoteDAO;
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
        /**
         * 该用户从未对该问题或者答案做出Vote
         */
        if(resultList==null){
             System.err.println("Vote！！！！");
             save(vote);

        }else if(resultList.size()==0){

            System.err.println("Vote！！！！");
            save(vote);
        }else if(resultList.size()>=1){
            /**
             * 重复Vote,取消赞
             */
            if(vote.getVoteType()==resultList.get(0).getVoteType()){
                System.out.println();
                System.err.println("重复操作,取消赞！！！！");
                baseDAO.delete(Vote.class,resultList.get(0).getId());

            }else{
                System.err.println("改变操作！！！！");
                baseDAO.delete(Vote.class , resultList.get(0).getId());
                save(vote);

            }
        }


        return 0;
    }

    @Override
    public void cancel(Vote vote) {
        Query query = em.createQuery
                ("from Vote v where v.authorId = ?1 and  ( v.answerId =?2 or v.questionId = ?3)");
        query.setParameter(1,vote.getAuthorId());
        query.setParameter(2,vote.getAnswerId());
        query.setParameter(3,vote.getQuestionId());

        List<Vote>result = query.getResultList();
        if(result!=null && result.size()>0) {
            baseDAO.delete(Vote.class , result.get(0).getId());
        }else{
            System.out.print("取消不存在的Vote!!!!");
        }


    }

    @Override
    public boolean hasVoteQuestion(long userId, long questionId, VoteType type) {
        Query query = em.createQuery
                (" from Vote v where v.authorId = ?1 and v.questionId = ?2 ");
        query.setParameter(1,userId);
        query.setParameter(2,questionId);
        List<Vote> resultList = query.getResultList();
        if(resultList==null){
            return false;
        }else if(resultList.size()==0){
            return  false;
        }
        return true;

    }

    @Override
    public boolean hasVoteAnswer(long userId, long answerId, VoteType type) {
        Query query = em.createQuery
                (" from Vote v where v.authorId = ?1 and v.answerID = ?2 ");
        query.setParameter(1,userId);
        query.setParameter(2,answerId);
        List<Vote> resultList = query.getResultList();
        if(resultList==null){
            return false;
        }else if(resultList.size()==0){
            return  false;
        }
        return true;
    }
}
