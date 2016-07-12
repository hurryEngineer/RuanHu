package edu.nju.logic.impl;

import edu.nju.RuanHuApplication;
import edu.nju.data.entity.Users;
import edu.nju.data.util.VerifyResult;
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
public class LoginImpTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void verifyLogin() throws Exception {
        VerifyResult verifyResult = loginService.verifyLogin("","");
        Assert.assertTrue(verifyResult==VerifyResult.INEXISTENCE);
        verifyResult = loginService.verifyLogin("ch","1234567");
        Assert.assertTrue(verifyResult==VerifyResult.INCORRECT);
        verifyResult = loginService.verifyLogin("ch","123456");
        Assert.assertTrue(verifyResult==VerifyResult.SUCCESS);
    }

    @Test
    public void getCurrentUser() throws Exception {
        Users users = loginService.getCurrentUser("ch");
        Assert.assertTrue(users!=null);
    }

}