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

import static org.junit.Assert.*;

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

}