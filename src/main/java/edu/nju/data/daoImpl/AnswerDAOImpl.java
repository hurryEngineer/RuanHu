package edu.nju.data.daoImpl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.BaseDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.util.common_paras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ss14 on 2016/7/13.
 */
@Repository
@Transactional
public class AnswerDAOImpl implements AnswerDAO {
    @Autowired
    BaseDAO baseDAO;
    @PersistenceContext
    EntityManager em;


    private static String tableName = "Answer";

    @Override
    public void save(Answer answer) {
        baseDAO.insert(answer);
    }

    @Override
    public long save_id(Answer answer) {
        em.persist(answer);
        em.flush();
        return answer.getId();
    }

    @Override
    public Answer save_answer(Answer answer) {
        em.persist(answer);
        em.flush();
        return answer;
    }

    @Override
    public void deleteByAnswerID(long AnswerID) {
        baseDAO.delete(Answer.class,AnswerID);
    }

    @Override
    public int deleteByQuestionID(long questionID) {
        Query query = em.createQuery("delete from Answer as a where a.questionId = ?1");
        query.setParameter(1,questionID);
        int size=query.executeUpdate();
        return size;
    }

    @Override
    public int deleteByUserID(long userID) {
        Query query = em.createQuery("delete from Answer as a where a.author.id = ?1");
        query.setParameter(1,userID);
        int size=query.executeUpdate();
        return size;
    }

    @Override
    public int deleteByQuestion_UserID(long questionID, long userID) {
        Query query = em.createQuery("delete from Answer as a where a.author.id = ?2 and a.questionId = ?1");
        query.setParameter(1,questionID);
        query.setParameter(2,userID);
        int size=query.executeUpdate();
        return size;
    }

    @Override
    public void update(Answer answer) {

    }

    @Override
    public void setSolution(long AnswerID) {

        Query query = em.createQuery("update Answer a set a.solution = 1 where a.id = ?1");
        query.setParameter(1,AnswerID);
        query.executeUpdate();

    }

    @Override
    public Answer getAnswerByID(long answerID) {
        Query query = em.createQuery("from Answer a where a.id =?1");
        query.setParameter(1,answerID);
        return (Answer) query.getResultList().get(0);
    }

    @Override
    public List<Answer> getAnswerByQuestionID(long questionID) {

        Query query = em.createQuery("from Answer a where a.questionId =?1");
        query.setParameter(1,questionID);
        List<Answer> result =  query.getResultList();
        return  result;
    }

    @Override
    public List<Answer> getAnswerByQuestionID(long questionID, int pageNum) {
        return (List<Answer>) baseDAO.getPaginatedContent(tableName,pageNum, common_paras.default_pageSize);
    }

    @Override
    public List<Answer> getAnswerByQuestionID(long questionID, int pageNum, int pageSize) {
        return (List<Answer>) baseDAO.getPaginatedContent(tableName,pageNum, pageSize);
    }


    @Override
    public List<Answer> getAnswerByUserName(String username) {
        return null;
    }

    @Override
    public long getAnswerCountByUserName(String username) {
        return 0;
    }

    @Override
    public List<Answer> getAnswerByUserID(long ID) {
        return null;
    }

    @Override
    public long getAnswerCountByUserID(long ID) {
        return 0;
    }


}
