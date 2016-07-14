package edu.nju.web.controller;

import edu.nju.RuanHuApplication;
import edu.nju.data.entity.User;
import edu.nju.logic.service.LoginService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cuihao on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
@Rollback
@Transactional
public class LoginControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    private LoginService loginService;

    private MockMvc mockMvc;

    private HashMap<String, Object> sessionMap = new HashMap<>();

    @Before
    public void initSession() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void login() throws Exception {
    }

    @Test
    public void loginVerify() throws Exception {
         mockMvc.perform(get("/loginVerify").param("account","ch")
        .param("password","123456")).andExpect(status().isOk());
    }

    @Test
    public void logout() throws Exception {
        User user = loginService.getCurrentUser("ch");
        sessionMap.put("user",user);
        mockMvc.perform(get("/logout").sessionAttrs(sessionMap)).andExpect(status().isOk());
    }

}