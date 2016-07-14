package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.VoteDAO;
import edu.nju.data.entity.Vote;
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
        Query query = em.createQuery
                ("select count (*) from Vote v where v.authorId = ?1 and  ( v.answerId =?2 or v.questionId = ?3)");
        query.setParameter(1,vote.getAuthorId());
        query.setParameter(2,vote.getAnswerId());
        query.setParameter(3,vote.getQuestionId());
        Long result = (Long) query.getSingleResult();

        if(result>0){
            System.out.print("不能重复点赞！！！！！！！！");
        }else{
            baseDAO.insert(vote);
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
