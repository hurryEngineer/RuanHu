package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.MessageDAO;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;
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
public class MessageDAOImplTest {

    @Autowired
    MessageDAO messageDAO;


    @Test
    public void save_Message() throws Exception {

        Message message = new Message();
        MesType type = MesType.invite;
        Long srcId = new Long (283);
        Long senderId = new Long(2);
        Long receiverId = new Long (3);
        message.setMesgType(type);
        message.setSourceId(srcId);
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);

        Message loaded = messageDAO.save_Message(message);
        if(loaded==null){
            fail();
        }else if(loaded.getId()==null){
            fail();
        }



    }

    @Test
    public void markChecked() throws Exception {

        messageDAO.markChecked((long) 2);

    }

    @Test
    public void deleteByMesID() throws Exception {
        messageDAO.deleteByMesID((long) 2);
    }


    @Test
    public void sendMessage() throws Exception {
        MesType type = MesType.comment;

        Long srcID = new Long(283);
        User sender = new User();
        sender.setId(new Long(2));
        sender.setUserName("ss14");

        User re = new User();
        re.setId(new Long(3));


        messageDAO.sendMessage(type,srcID,sender,re);

    }

}