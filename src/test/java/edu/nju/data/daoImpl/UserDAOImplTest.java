package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
public class UserDAOImplTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void exists() throws Exception {
        String username = "ss14";
        if(!userDAO.exists(username)){
            fail("exists()--------");
        }

    }

    @Test
    public void verify() throws Exception {

    }

    @Test
    public void login() throws Exception {

    }

    @Test
    public void getUserByName() throws Exception {

    }

}