package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by ss14 on 2016/7/20.
 */
@Repository
@Transactional
public class DocumentDAOImpl implements DocumentDAO {
    @Autowired
    private BaseDAO baseDAO;
    @PersistenceContext
    private EntityManager em;


    @Override
    public List getRelatedWikis(long docuID)
    {
        Query query = em.createQuery(" select wikiID from QuestionWiki join QuestionDocument where docuID = ?1");
        query.setParameter(1,docuID);
        List resultQuestion = query.getResultList();

        query = em.createQuery(" select wikiID from AnswerWiki join AnswerDocument where docuID = ?1");
        query.setParameter(1,docuID);
        List resultAnswer = query.getResultList();

        resultQuestion.addAll(resultAnswer);

        return  resultQuestion;
    }

    @Override
    public List getRelatedQuestions(long docuID) {
        Query query = em.createQuery(" select questionID from QuestionDocument where documentID = ?1");
        query.setParameter(1,docuID);
        List result = query.getResultList();
        return  result;
    }
}
