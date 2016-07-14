package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.entity.Question;
import edu.nju.data.util.common_paras
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */
@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    BaseDAO baseDAO;

    @PersistenceContext
    EntityManager em;

    private static String tableName = "Question";



    @Override
    public void save(Question question) {

        baseDAO.insert(question);

    }

    @Override
    public long save_id(Question question) {
        em.persist(question);
        em.flush();
        return question.getId();
    }

    @Override
    public Question save_question(Question question) {
        em.persist(question);
        em.flush();
        return question;
    }


    @Override
    public void deleteByQuestionID(long questionID) {

        baseDAO.delete(Question.class,questionID);

    }

    @Override
    public int  deleteByAuthorID(long authorID) {
        Query query = em.createQuery("delete  Question where authorId = ?1");
        query.setParameter(1,authorID);
        int result = query.executeUpdate();
        return result;
    }

    @Override
    public void update(Question question) {
        baseDAO.update(question);

    }

    @Override
    public Question getQuestionByID(long QuestionID) {
        return (Question) baseDAO.load(Question.class, QuestionID);
    }

    @Override
    public List<Question> getPaginatedQuestions(int pageNum) {

        return (List<Question>) baseDAO.getPaginatedContent(tableName,pageNum,common_paras.default_pageSize);
    }

    @Override
    public List<Question> getPaginatedQuestions(int pageNum, int pageSize) {
        return (List<Question>) baseDAO.getPaginatedContent(tableName,pageNum,pageSize);
    }

    @Override
    public List<Question> getQuestionByUsername(String userName)
    {
        Query query = em.createQuery("select q from Question q,User u where q.authorId=u.id and u.userName = ?1");
        query.setParameter(1,userName);

        return query.getResultList();
    }

    @Override
    public long getQuestionCountByUsername(String username) {
        Query query = em.createQuery("select count(q) from Question q,User u where q.authorId=u.id and u.userName = ?1");
        query.setParameter(1,username);

        return (long) query.getSingleResult();
    }

    @Override
    public List<Question> getQuestionByUserID(long userID) {
        Query query = em.createQuery("from Question q where q.authorId= ?1");
        query.setParameter(1,userID);
        return query.getResultList();
    }

    @Override
    public long getQuestionCountByUserID(long userID) {
        Query query = em.createQuery("select count (q) from Question q where q.authorId= ?1");
        query.setParameter(1,userID);
        return (long) query.getSingleResult();
    }
}
