package edu.nju.web.controller;

import edu.nju.RuanHuApplication;
import edu.nju.logic.service.LoginService;
import edu.nju.web.controller.LoginController;

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
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    public void login() throws Exception {
    }

    @Test
    public void loginVerify() throws Exception {
    }

    @Test
    public void logout() throws Exception {

    }

}