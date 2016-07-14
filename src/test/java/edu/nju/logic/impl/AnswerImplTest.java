package edu.nju.logic.impl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import edu.nju.logic.service.AnswerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cuihao on 2016/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
@Rollback
@Transactional
public class AnswerImplTest {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void markAsSolution() throws Exception {
        User user = userDAO.getUserByName("ch");
        boolean test = answerService.markAsSolution(user,1,1);
        Assert.assertTrue(test);
        user.setId(user.getId()+1);
        test = answerService.markAsSolution(user,1,1);
        Assert.assertTrue(!test);
    }

    @Test
    public void saveAnswer() throws Exception {
        boolean test = answerService.saveAnswer(0,0,"###This is an answer\n![]{www.baidu.com}");
        Assert.assertTrue(test);
    }

}