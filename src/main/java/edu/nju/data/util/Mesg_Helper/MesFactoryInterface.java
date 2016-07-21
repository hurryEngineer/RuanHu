package edu.nju.data.util.Mesg_Helper;

import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;

import java.util.List;

/**
 * Created by ss14 on 2016/7/21.
 */
public interface MesFactoryInterface {



    String createContent(MesType type , String receiverName);


    /**
     * 创建单条消息，消息的content字段由系统提供
     * @param type
     * @param srcID
     * @param sender
     * @param receiver
     * @return
     */
    Message createMesage(MesType type , Long srcID , User sender , User receiver);


    /**
     * 根据接收者列表来创建多条同类型的消息
     * @param type
     * @param srcID
     * @param sender
     * @param receivers
     * @return
     */
    List<Message> createMesage(MesType type , Long srcID , User sender , List<User> receivers);

}
