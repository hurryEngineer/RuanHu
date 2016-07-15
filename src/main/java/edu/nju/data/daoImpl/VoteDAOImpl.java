package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.VoteDAO;
import edu.nju.data.entity.Vote;
import edu.nju.data.util.VoteType;
import org.springframework.beans.factory.ObjectFactory;
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
    public void vote(Vote vote) {
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
             save(vote);
        }else if(resultList.size()==1){
            /**
             * 重复Vote不做处理
             */
            if(vote.getVoteType()==resultList.get(0).getVoteType()){

            }else{

                baseDAO.delete(Vote.class , resultList.get(0).getId());
                save(vote);

            }
        }
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
}
