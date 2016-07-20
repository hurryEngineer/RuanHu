package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by ss14 on 2016/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
public class AnswerDAOImplTest {



    @Autowired
    AnswerDAO answerDAO;
    @PersistenceContext
    EntityManager em;

    @Test
    public void save() throws Exception {

        for (int k=239;k<259 ;k++){
            for(int j=1;j<=4 ;j++){
                    Answer answer = new Answer();
                    answer.setAuthorId(new Long(j));
                    answer.setQuestionId(new Long (k));
                    answerDAO.save(answer);
            }
        }




    }

    @Test
    public void getAnswerByID() throws Exception {
        Long id = new Long (1);
        Answer answer =  answerDAO.getAnswerByID(id);
        if(answer==null){
            fail();
        }else if(answer.getQuestion()==null){
            fail();
        }else if(answer.getQuestion().getId()!=1){
            fail();
        }else if(answer.getCommentList()==null){
            fail();
        }else if(answer.getCommentList().size()!=2){
            fail();
        }else {
            System.out.println("AnswerID: "+answer.getId());
            System.out.println("QuestionID: "+answer.getQuestion().getId());
            System.out.println("Second comment ID: "+answer.getCommentList().get(1).getId());
        }


    }


    @Test
    public void save_id() throws Exception {

    }

    @Test
    public void save_answer() throws Exception {

    }

    @Test
    public void createAnswer() throws Exception {
        Answer answer = new Answer();
        answer.setAuthorId(new Long(2));
        answer.setQuestionId(new Long(333));
        answer.setContent("加速起跑，半蹲，后脚踮起，重心压在后脚尖，前脚翻韧90°迅速蹬出");
        List wikiIDs = new ArrayList();
        List docuIDs = new ArrayList();
        for(long i=1;i<=3;i++){
            wikiIDs.add(i);
            docuIDs.add(2*i-1);
        }

        answerDAO.createAnswer(answer , wikiIDs , docuIDs );
    }


    @Test
    public void deleteByAnswerID() throws Exception {

    }

    @Test
    public void deleteByQuestionID() throws Exception {
       // Long questionID = new


    }

    @Test
    public void deleteByUserID() throws Exception {

    }

    @Test
    public void deleteByQuestion_UserID() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }


    @Test
    public void setSolution() throws Exception {

        Long questionID = new Long (239);
        Long answerID = new Long (2);
        answerDAO.setSolution(questionID,answerID);

    }


    @Test
    public void cancelSolution() throws Exception {

        Long answerID = new Long (1);
        answerDAO.cancelSolution(answerID);
    }


    /**
     * 获取全部的回答
 //    * @param questionID
     * @return
     */
    @Test
    public void getAnswerByQuestionID() throws Exception {
//        Long questionID = new Long (1);
//       // List<Answer> result = answerDAO.getAnswerByQuestionID(questionID);
//        if(result==null){
//            fail();
//        }else if(result.size()==0){
//            fail();
//        }else{
//
//        }

    }

    /**
     * 不排序
     * 获取某页的回答，页面大小默认是10
//     * @param questionID
//     * @param pageNum
     * @return
     */
    @Test
    public void getAnswerByQuestionID1() throws Exception {
//        Long questionID = new Long (1);
//        int pageNum=1;
//        List<Answer> result = answerDAO.getAnswerByQuestionID(questionID ,pageNum);
//        if(result==null){
//            fail();
//        }else if(result.size()!=10){
//            fail();
//        }else{
//
//        }
    }

    /**
     * 不排序
     * 获取某页的回答，自定义页面大小
//     * @param questionID
//     * @param pageNum
//     * @param pageSize
     * @return
     */
    @Test
    public void getAnswerByQuestionID2() throws Exception {
//        Long questionID = new Long (1);
//        int pageNum=1;
//        int pageSize=15;
//        List<Answer> result = answerDAO.getAnswerByQuestionID(questionID ,pageNum,pageSize);
//        if(result==null){
//            fail();
//        }else if(result.size()!=pageSize){
//            fail();
//        }else{
//
//        }
    }
    /**
     * 根据参数排序，默认降序
//     * @param questionID
//     * @param pageNum
//     * @param para
     * @return
     */
    @Test
    public void getAnswerByQuestionID3() throws Exception {
//        Long questionID = new Long (1);
//        int pageNum=1;
//        List<Answer> result = answerDAO.getAnswerByQuestionID
//                (questionID ,pageNum, OrderByPara.createdAt);
//        if(result==null){
//            fail();
//        }else if(result.size()!=10){
//            fail();
//        }else{
//            for(Answer answer : result){
//                System.out.println("AnswerID : "+answer.getId() + " "+answer.getCreatedAt());
//            }
//
//        }
    }
    /**
     * 根据参数排序，默认降序
//     * @param questionID
//     * @param pageNum
//     * @param pageSize
     * @return
     */
    @Test
    public void getAnswerByQuestionID4() throws Exception {
//        Long questionID = new Long (1);
//        int pageNum=1;
//        int pageSize=15;
//        List<Answer> result = answerDAO.getAnswerByQuestionID
//                (questionID ,pageNum,pageSize, OrderByPara.createdAt);
//        if(result==null){
//            fail();
//        }else if(result.size()!=pageSize){
//            fail();
//        }else{
//            for(Answer answer : result){
//                System.out.println("AnswerID : "+answer.getId() + " "+answer.getCreatedAt());
//            }
//
//        }
    }
    /**
     * 根据参数和排序方式，进行排序
//     * @param questionID
//     * @param pageNum
//     * @param para
//     * @param method
     * @return
     */
    @Test
    public void getAnswerByQuestionID5() throws Exception {
//        Long questionID = new Long (1);
//        int pageNum=1;
//        List<Answer> result = answerDAO.getAnswerByQuestionID
//                (questionID ,pageNum, OrderByPara.createdAt, OrderByMethod.ASC);
//        if(result==null){
//            fail();
//        }else if(result.size()!=10){
//            fail();
//        }else{
//            for(Answer answer : result){
//                System.out.println("AnswerID : "+answer.getId() + " "+answer.getCreatedAt());
//            }
//
//        }
    }

    /**
     *  根据参数和排序方式，进行排序
//     * @param questionID
//     * @param pageNum
//     * @param pageSize
     * @return
     */
    @Test
    public void getAnswerByQuestionID6() throws Exception {
//        Long questionID = new Long (1);
//        int pageNum=1;
//        int pageSize=15;
//        List<Answer> result = answerDAO.getAnswerByQuestionID
//                (questionID ,pageNum,pageSize, OrderByPara.createdAt ,OrderByMethod.ASC);
//        if(result==null){
//            fail();
//        }else if(result.size()!=pageSize){
//            fail();
//        }else{
//            for(Answer answer : result){
//                System.out.println("AnswerID : "+answer.getId() + " "+answer.getCreatedAt());
//            }
//
//        }

    }



    @Test
    public void getAnswerByUserName() throws Exception {


//        String username = "ss14";
//        List<Answer> result = answerDAO.getAnswerByUserName(username);
//        if(result==null){
//            fail();
//        }else{
//            for(Answer answer : result){
//                System.out.println("Answer ID : "+answer.getId()+" UserName :"+answer.getAuthor().getUserName());
//            }
//        }


    }

    @Test
    public void getAnswerCountByUserName() throws Exception {

        String username = "ss14";
        long  result = answerDAO.getAnswerCountByUserName(username);
        if(result==0){
            fail();
        }else{
            System.out.println("AnswerCount : "+result);
        }

    }

    @Test
    public void getAnswerByUserID() throws Exception {

//        Long userid = new Long (2) ;
//        List<Answer> result = answerDAO.getAnswerByUserID(userid);
//        if(result==null){
//            fail();
//        }else{
//            for(Answer answer : result){
//                System.out.println("Answer ID : "+answer.getId()+" UserName :"+answer.getAuthor().getUserName());
//            }
//        }

    }

    @Test
    public void getAnswerCountByUserID() throws Exception {
        Long userid = new Long(2);
        long  result = answerDAO.getAnswerCountByUserID(userid);
        if(result==0){
            fail();
        }else{
            System.out.println("AnswerCount : "+result);
        }
    }




}