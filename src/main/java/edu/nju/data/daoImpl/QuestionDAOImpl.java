package edu.nju.data.daoImpl;

import edu.nju.data.dao.*;
import edu.nju.data.dao.http.Tss_httpDAO;
import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.CommonParas;
import edu.nju.data.util.HQL_Helper.Enums.FromPara;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;
import edu.nju.data.util.HQL_Helper.Impl.QueryHqlMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */
@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    BaseDAO baseDAO;
    @Autowired
    OrderedPageDAO pageDAO;
    @Autowired
    QueryHqlMaker hqlMaker;
    @Autowired
    WikiDAO wikiDAO;
    @Autowired
    DocumentDAO documentDAO;
    @Autowired
    Wiki_httpDAO wiki_httpDAO;
    @Autowired
    Tss_httpDAO docu_httpDAO;

    @PersistenceContext
    EntityManager em;

    private static String tableName = "Question";



    @Override
    public void save(Question question) {

        question.setId(null);
        baseDAO.insert(question);

    }

    @Override
    public long save_id(Question question) {
        question.setId(null);
        em.persist(question);
        em.flush();
        return question.getId();
    }

    @Override
    public Question save_question(Question question) {
        question.setId(null);
        em.persist(question);
        em.flush();
        return question;
    }

    @Override
    public Question createQuestion(Question question, List wikiIDs, List docuIDs) {

        Question result = save_question(question);
        wikiDAO.insertQuestion(result.getId() , wikiIDs);
        documentDAO.insertQuestion(result.getId(),docuIDs);
        return result;

    }


    @Override
    public void deleteByQuestionID(long questionID) {

        baseDAO.delete(Question.class,questionID);

    }

    @Override
    public int  deleteByAuthorID(long authorID) {
        Query query = em.createQuery("delete  Question where author.id = ?1");
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
    public List<Question> getQuestionBy(WherePara byPara, Object arg) {
        String hql =hqlMaker.getHQLby(FromPara.Quesstion ,byPara);
        Query query = em.createQuery(hql);
        query.setParameter(1,arg);
        List<Question> result = query.getResultList();
        return result;
    }

    @Override
    public List<Question> getPagedQuestions(int pageNum) {
        String hql = hqlMaker.getHQLby(FromPara.Quesstion, null);
        return (List<Question>) pageDAO.execHQL(hql,pageNum, CommonParas.default_pageSize);

    }

    @Override
    public List<Question> getPagedQuestions(int pageNum, int pageSize) {
        String hql = hqlMaker.getHQLby(FromPara.Quesstion, null);
        return (List<Question>) pageDAO.execHQL(hql,pageNum, pageSize);

    }

    @Override
    public List<Question> getOrderedPagedQuestions(int pageNum, OrderByPara orderByPara) {

        String hql = hqlMaker.getHQLby(FromPara.Quesstion, null ,orderByPara , OrderByMethod.DESC);
        return (List<Question>) pageDAO.execHQL(hql,pageNum, CommonParas.default_pageSize);
    }

    @Override
    public List<Question> getOrderedPagedQuestions(int pageNum, int pageSize, OrderByPara orderByPara, OrderByMethod orderByMethod) {
        String hql = hqlMaker.getHQLby(FromPara.Quesstion, null ,orderByPara , orderByMethod);
        return (List<Question>) pageDAO.execHQL(hql,pageNum, pageSize);
    }

    @Override
    public List<Question> getOrderedPagedQuestionsBy(WherePara byPara, Object arg, int pageNum, OrderByPara orderByPara) {
        String hql = hqlMaker.getHQLby(FromPara.Quesstion, byPara ,orderByPara , OrderByMethod.DESC);
        return (List<Question>) pageDAO.execHQL(hql,pageNum, CommonParas.default_pageSize , arg);
    }

    @Override
    public List<Question> getOrderedPagedQuestionsBy(WherePara byPara, Object arg, int pageNum, int pageSize, OrderByPara orderByPara, OrderByMethod orderByMethod) {
        String hql = hqlMaker.getHQLby(FromPara.Quesstion, byPara ,orderByPara , orderByMethod);
        return (List<Question>) pageDAO.execHQL(hql,pageNum, pageSize , arg);
    }

    @Override
    public List<Question> getAllQuestions() {

        Query query = em.createQuery("from Question ");
        return query.getResultList();
    }



    @Override
    public long getQuestionCountByUsername(String username) {
        Query query = em.createQuery("select count(q) from Question q,User u where q.author.id=u.id and u.userName = ?1");
        query.setParameter(1,username);

        return (long) query.getSingleResult();
    }


    @Override
    public long getQuestionCountByUserID(long userID) {
        Query query = em.createQuery("select count (q) from Question q where q.author.id= ?1");
        query.setParameter(1,userID);
        return (long) query.getSingleResult();
    }



    @Override
    public List<WikiItem> getRelatedWikiItems(long QuestionID)
    {
        List<WikiItem> result = new ArrayList<>();
        List ids = new ArrayList();
        /**
         * 首先获取与该问题相关的wiki
         */
        Query query = em.createQuery("select qw.wikiId from QuestionWiki qw where qw.questionId = ?1 ");
        query.setParameter(1,QuestionID);
        ids.addAll(query.getResultList());

        for(int i=0;i<ids.size();i++){
            try {
                result.add(wiki_httpDAO.getWikiById((Long) ids.get(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    @Override
    public List<Document> getRelatedDocuments(long QuestionID) {
        List<Document> result = new ArrayList<>();
        List ids = new ArrayList();

        Query query =
                em.createQuery("select qd.documentId from QuestionDocument qd where qd.questionId = ?1");
        query.setParameter(1,QuestionID);
        ids.addAll(query.getResultList());

        for(int i=0;i<ids.size();i++){
            try {
                result.add(docu_httpDAO.getDocumentById((Long) ids.get(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;


    }
}
