package edu.nju.logic.impl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import edu.nju.logic.service.UserProfileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * Created by cuihao on 2016/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
@Rollback
@Transactional
public class UserProfileImplTest {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void editProfile() throws Exception {
        User user = userDAO.getUserByName("ch");
        userProfileService.editProfile(user, "description","jiangsu","2015-01-01");
        user = userDAO.getUserByName("ch");
        Assert.assertTrue(user.getDescription().equals("description"));
        Assert.assertTrue(user.getLocation().equals("jiangsu"));
        Assert.assertTrue(user.getBirthDate().getTime()== Date.valueOf("2015-01-01").getTime());
    }

}