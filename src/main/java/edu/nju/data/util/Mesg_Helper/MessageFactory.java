package edu.nju.data.util.Mesg_Helper;

import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ss14 on 2016/7/21.
 */
@Repository
public class MessageFactory implements MesFactoryInterface {


    @Override
    public String createContent(MesType type, String receiverName) {
        return null;
    }

    @Override
    public Message createMesage(MesType type, Long srcID, User sender , User receiver) {
        Message message = new Message();
        message.setMesgType(type);
        message.setSourceId(srcID);
        message.setSenderId(sender.getId());
        message.setReceiverId(receiver.getId());
        return message;
    }

    @Override
    public List<Message> createMesage(MesType type, Long srcID, User sender, List<User> receivers) {
        return null;
    }


}
