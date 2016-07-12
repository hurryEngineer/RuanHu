package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.entity.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
public class QuestionDAOImplTest {
    @Autowired
    QuestionDAO questionDAO;

    @Test
    public void getQuestionByID() throws Exception {
        long id =1 ;
        Question question = questionDAO.getQuestionByID(id);
        String title = "q1";
        String content = "c1";
        if(question==null){
            fail();
        }else if (!title.equals(question.getTitle()) ||
                     !content.equals(question.getContent())){
            fail();
        }


    }

    @Test
    public void getQuestionByUsername() throws Exception {

        long userID = 1 ;
        String username = "ch";
        int resultSize =2;
        String q1 = "q1";
        String q2 = "q2";
        List<Question> questionList = questionDAO .getQuestionByUsername(username);
        if(questionList==null){
            fail("null");
        }else if ( questionList.size()!=resultSize){
            fail("size");
        }else if (questionList.get(0).getAuthorId()!=userID){
            fail("userID");
        }else{
            for (Question question : questionList){

                System.out.println("questionID: "+question.getId());
                System.out.println("userID: "+question.getAuthorId());

            }
        }


    }

}