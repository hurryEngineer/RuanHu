package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.MessageDAO;
import edu.nju.data.entity.Message;
import edu.nju.data.util.MesType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
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

    }

    @Test
    public void deleteByMesID() throws Exception {

    }


    @Test
    public void sendMessage() throws Exception {

    }

}