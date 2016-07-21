package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import edu.nju.data.util.VerifyResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
@Rollback
public class UserDAOImplTest {



    @Autowired
    UserDAO userDAO;


    @Test
    public void save() throws Exception {

        User user = new User();
        String userName = "侍硕的小号";
        String pw = "123";
        user.setUserName(userName);
        user.setPassword(pw);
        userDAO.save(user);

        if(!userDAO.getUserByName(userName).getPassword().equals(pw)){
            fail();
        }
    }



    @Test
    public void update() throws Exception {
      for(int i=1;i<=4 ;i++){
          User user = userDAO.getUserByID(new Long(i));
          userDAO.update(user);
      }


    }

    @Test
    public void exists() throws Exception {
        String username = "ch";
        String username1 = "cc";
        if(!userDAO.exists(username)){
            fail("exists()--------");
        }

        if(userDAO.exists(username1)){
            fail("exists()--------");
        }

    }

    @Test
    public void verify() throws Exception {

        String name = "ch";
        String pw = "123456";
        if(!userDAO.verify(name,pw)){
            fail("verify()-------");
        }else{
            System.out.println("name : "+name);
            System.out.println("pw : "+pw);
        }

    }

    @Test
    public void login() throws Exception {
        String name = "ch";
        String pw = "123456";
        String name1 = "ch1";
        String pw1 = "1234567";
        VerifyResult success = userDAO.login(name,pw);
        VerifyResult inexist =userDAO.login(name1,pw);
        VerifyResult incorrect = userDAO.login(name,pw1);
        if(success!=VerifyResult.SUCCESS  ||
                inexist !=VerifyResult.INEXISTENCE  ||
                   incorrect !=VerifyResult.INCORRECT){
            fail("login()-----------");
        }


    }

    @Test
    public void getUserByName() throws Exception {

        String username = "ch";
        User user = userDAO.getUserByName(username);
        if(user==null){
            fail("--");
        }

    }



    @Test
    public void search() throws Exception {

        String partName = "1";
        List<User> users = userDAO.search(partName);
        if(users==null){
            fail();
        }else{
            System.out.print("\n");
            for(User user: users){
                System.out.println(user.getUserName());
            }
        }

    }

    @Test
    public void getAllMessage() throws Exception {

    }

}