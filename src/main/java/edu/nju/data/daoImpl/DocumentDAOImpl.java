package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.DocumentDAO;
import edu.nju.data.entity.AnswerDocument;
import edu.nju.data.entity.QuestionDocument;
import edu.nju.data.entity.QuestionWiki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        Query query = em.createQuery(" select qw.wikiId from QuestionWiki qw , QuestionDocument qd  where qd.documentId = ?1");
        query.setParameter(1,docuID);
        List resultQuestion = query.getResultList();

        query = em.createQuery(" select aw.wikiId from AnswerWiki aw , AnswerDocument ad where ad.documentId = ?1");
        query.setParameter(1,docuID);
        List resultAnswer = query.getResultList();

        Set resultSet = new HashSet<>();
        resultSet.addAll(resultQuestion);
        resultSet.addAll(resultAnswer);

        List resultList = new ArrayList(resultSet);

        return  resultList;
    }

    @Override
    public List getRelatedQuestions(long docuID) {
        Query query = em.createQuery(" select qd.questionId from QuestionDocument qd where qd.documentId = ?1");
        query.setParameter(1,docuID);
        List result = query.getResultList();
        return  result;
    }

    @Override
    public void insertQuestion(long questionID, List docuIDs) {
        if(docuIDs==null){
            return ;
        }else {

            for(int i=0 ; i<docuIDs.size();i++){

                QuestionDocument qd = new QuestionDocument();
                qd.setQuestionId(questionID);
                qd.setDocumentId((Long) docuIDs.get(i));
                baseDAO.insert(qd);
            }
        }
    }

    @Override
    public void insertAnswer(long answerID, List docuIDs) {
        if(docuIDs==null){
            return ;
        }else {

            for(int i=0 ; i<docuIDs.size();i++){

                AnswerDocument ad = new AnswerDocument();
                ad.setAnswerId(answerID);
                ad.setDocumentId((Long) docuIDs.get(i));
                baseDAO.insert(ad);
            }
        }

    }
}
