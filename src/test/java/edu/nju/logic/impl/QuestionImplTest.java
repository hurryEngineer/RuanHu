package edu.nju.logic.impl;

import edu.nju.RuanHuApplication;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by Dora on 2016/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
@Rollback
@Transactional
public class QuestionImplTest {
    @Autowired
    QuestionService service;

    @Test
    public void showQuestion() throws Exception {

    }

    @Test
    public void saveQuestion() throws Exception {

        Question q = new Question();
        q.setContent("hahaha");
        q.setTitle("hhh");
      //  q.setAuthorId(Long.valueOf("1"));
        q.setLastUpdatedAt(new Timestamp(new Date().getTime()));

        //System.out.println(service.saveQuestion(q,new User().getId()));
    }

}