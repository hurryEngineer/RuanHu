package edu.nju.data.daoImpl;


import edu.nju.data.dao.WikiDAO;
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
public class WikiDAOImpl implements WikiDAO {
    @PersistenceContext
    private EntityManager em;



    @Override
    public List getRelatedQuestions(long wikiID) {

        Query query = em.createQuery("select questionID from QuestionWiki  where wikiID = ?1");
        query.setParameter(1,wikiID);
        List result = query.getResultList();
        return result;
    }

    @Override
    public List getRelatedDocuments(long wikiID) {

        Query query = em.createQuery("select documentID from QuestionWiki join QuestionDocument where wikiID = ?1");
        query.setParameter(1,wikiID);
        List resultQuestion = query.getResultList();

        query = em.createQuery("select documentID from AnswerWiki join AnswerDocument where wikiID = ?1");
        query.setParameter(1,wikiID);
        List resultAnswer = query.getResultList();

        resultQuestion.addAll(resultAnswer);

        return resultQuestion;
    }
}
