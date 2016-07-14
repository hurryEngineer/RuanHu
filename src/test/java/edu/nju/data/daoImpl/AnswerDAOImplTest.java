package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.entity.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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

    @Test
    public void save() throws Exception {

        Long authorID = new Long (1);
        Long questionID = new Long (1);
        Answer answer = new Answer();
        answer.setAuthorId(authorID);
        answer.setQuestionId(questionID);
        answerDAO.save(answer);

    }

    @Test
    public void save_id() throws Exception {


    }

    @Test
    public void save_answer() throws Exception {

    }

    @Test
    public void deleteByAnswerID() throws Exception {

    }

    @Test
    public void deleteByQuestionID() throws Exception {

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
    public void getAnswerByQuestionID() throws Exception {

    }

    @Test
    public void getAnswerByQuestionID1() throws Exception {

    }

    @Test
    public void getAnswerByQuestionID2() throws Exception {

    }

    @Test
    public void getAnswerByQuestionID3() throws Exception {

    }

    @Test
    public void getAnswerByQuestionID4() throws Exception {

    }

    @Test
    public void getAnswerByQuestionID5() throws Exception {

    }

    @Test
    public void getAnswerByQuestionID6() throws Exception {

    }

    @Test
    public void getAnswerByUserName() throws Exception {

    }

    @Test
    public void getAnswerCountByUserName() throws Exception {

    }

    @Test
    public void getAnswerByUserID() throws Exception {

    }

    @Test
    public void getAnswerCountByUserID() throws Exception {

    }

}