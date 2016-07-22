package edu.nju.data.util.Mesg_Helper;

import edu.nju.RuanHuApplication;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
public class MessageFactoryTest {
    @Autowired
    MesFactoryInterface mesFactory;

    @Test
    public void createMessage() throws Exception {
        MesType type = MesType.voteQuestion;
        Long srcID = new Long (283);
        User sender = new User();
        sender.setId(new Long(2));
        sender.setUserName("ss14");
        User receiver = new User();
        receiver.setId(new Long(1));

        Message message = mesFactory.createMessage(type,srcID,sender,receiver);
        if(message==null){
            fail();
        }else if(message.getMesgType()!=type){
            fail();
        }else{
            System.out.print("\n");
            System.out.println(message.getContent());
        }


    }

    @Test
    public void createMessage1() throws Exception {
        MesType[] types = {MesType.answer,MesType.invite , MesType.comment ,MesType.voteQuestion};

        Long srcID = new Long (283);
        User sender = new User();
        sender.setId(new Long(2));
        sender.setUserName("ss14");
        User receiver = new User();
        receiver.setId(new Long(1));

        User receiver1 = new User();
        receiver1.setId(new Long(3));

        List<User> receivers = new ArrayList<>();
        receivers.add(receiver);
        receivers.add(receiver1);

        for(MesType type : types){
            List<Message> messages = mesFactory.createMessage(type,srcID,sender,receivers);
            if(messages==null){
                fail();
            }else{

                System.out.print("\n");
                for(Message message : messages){
                    System.out.println(message.getContent());
                }

            }
        }


    }

}