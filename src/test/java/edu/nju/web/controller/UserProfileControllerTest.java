package edu.nju.web.controller;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cuihao on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class UserProfileControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserDAO userDAO;

    private MockMvc mockMvc;

    private Map<String, Object> sessionMap = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        User user = userDAO.getUserByName("ch");
        sessionMap.put("user",user);
    }

    @Test
    public void showProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userProfile/show").sessionAttrs(sessionMap)).andExpect(status().isOk());
    }

    @Test
    public void editProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userProfile/edit").sessionAttrs(sessionMap)
        .param("description","description1").param("location","location1").param("birthday","2016-01-01")).andExpect(status().isOk());
        User user = userDAO.getUserByName("ch");
        Assert.assertTrue(user.getDescription().equals("description1"));
        Assert.assertTrue(user.getLocation().equals("location1"));
        Assert.assertTrue(user.getBirthDate().getTime()== Date.valueOf("2016-01-01").getTime());
    }

}