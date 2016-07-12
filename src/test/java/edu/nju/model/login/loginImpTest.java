package edu.nju.model.login;

import edu.nju.RuanHuApplication;
import edu.nju.data.entity.Users;
import edu.nju.logic.service.LoginService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class loginImpTest {
    @Autowired
    private LoginService loginService;

    @Test
    public void verifyLogin() throws Exception {
        Users users = loginService.verifyLogin("","");
        Assert.assertTrue(users==null);
    }

}