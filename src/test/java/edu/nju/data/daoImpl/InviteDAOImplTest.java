package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.InviteDAO;
import edu.nju.data.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
@Rollback
public class InviteDAOImplTest {

    @Autowired
    InviteDAO inviteDAO;


    @Test
    public void invite() throws Exception {

        Long srcID = new Long(283);
        User sender = new User();
        sender.setId(new Long(1));
        sender.setUserName("ch");

        User re1 = new User();
        re1.setId(new Long(2));

        User re2 = new User();
        re2.setId(new Long(3));

        List<User> receivers= new ArrayList<>();
        receivers.add(re1);
        receivers.add(re2);

        inviteDAO.invite(srcID,sender,receivers);


    }

}