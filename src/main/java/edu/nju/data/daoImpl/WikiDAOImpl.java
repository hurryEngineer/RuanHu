package edu.nju.data.daoImpl;


import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.WikiDAO;
import edu.nju.data.entity.AnswerWiki;
import edu.nju.data.entity.AnswerWikiPK;
import edu.nju.data.entity.QuestionWiki;
import edu.nju.data.entity.QuestionWikiPK;
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
public class WikiDAOImpl implements WikiDAO {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    BaseDAO baseDAO;



    @Override
    public List getRelatedQuestions(long wikiID) {

        Query query = em.createQuery("select qw.questionId from QuestionWiki qw  where qw.wikiId = ?1");
        query.setParameter(1,wikiID);
        List result = query.getResultList();
        return result;
    }

    @Override
    public List getRelatedDocuments(long wikiID) {

        Query query = em.createQuery("select qd.documentId from QuestionWiki qw, QuestionDocument qd " +
                "where qw.questionId = qd.questionId and qw.wikiId = ?1");
        query.setParameter(1,wikiID);
        List resultQuestion = query.getResultList();

        query = em.createQuery("select ad.documentId from AnswerWiki aw , AnswerDocument ad  " +
                "where aw.answerId = ad.answerId and aw.wikiId = ?1");
        query.setParameter(1,wikiID);
        List resultAnswer = query.getResultList();

        Set resultSet = new HashSet<>();
        resultSet.addAll(resultQuestion);
        resultSet.addAll(resultAnswer);

        List resultList = new ArrayList(resultSet);

        return resultList;
    }

    @Override
    public void insertQuestion(long questionID, List wikiIDs) {
        if(wikiIDs==null){
            return ;
        }else {

            for(int i=0 ; i<wikiIDs.size();i++){

                QuestionWikiPK pk = new QuestionWikiPK();
                pk.setQuestionId(questionID);
                pk.setWikiId((Long) wikiIDs.get(i));

                QuestionWiki qw = new QuestionWiki(pk);
                baseDAO.insert(qw);

            }
        }

    }

    @Override
    public void insertAnswer(long answerID, List wikiIDs) {
        if(wikiIDs==null){
            return ;
        }else {

            for(int i=0 ; i<wikiIDs.size();i++){
                AnswerWikiPK pk = new AnswerWikiPK();
                pk.setAnswerId(answerID);
                pk.setWikiId((Long) wikiIDs.get(i));

                AnswerWiki aw = new AnswerWiki(pk);
                baseDAO.insert(aw);

            }
        }
    }
}
