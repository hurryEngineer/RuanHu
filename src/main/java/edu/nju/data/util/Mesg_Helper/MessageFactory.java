package edu.nju.data.util.Mesg_Helper;

import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss14 on 2016/7/21.
 */
@Repository
public class MessageFactory implements MesFactoryInterface {



    private String createContent(MesType type, String senderName ) {
        String content;

        switch (type){

            case invite:

                content = senderName + "邀请我回答问题";

                break;

            case vote:

                content = senderName + "赞了我";

                break;
            case comment:

                content = senderName + "评论了我";
                break;
            case answer:

                content = senderName + "回答了我的问题";
                break;

            default:
                content = "";
        }

        return content;
    }

    @Override
    public Message createMessage(MesType type, Long srcID, User sender , User receiver) {
        Message message = new Message();
        message.setMesgType(type);
        message.setSourceId(srcID);
        message.setSenderId(sender.getId());
        message.setReceiverId(receiver.getId());
        message.setContent(createContent(type,sender.getUserName()) );
        return message;
    }

    @Override
    public List<Message> createMessage(MesType type, Long srcID, User sender, List<User> receivers) {
        List<Message> messages = new ArrayList<>();

        for (User receiver : receivers){
            messages.add( createMessage(type,srcID,sender,receiver) );
        }

        return messages;
    }


}
