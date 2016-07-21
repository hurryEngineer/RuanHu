package edu.nju.data.dao;

import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;

/**
 * Created by ss14 on 2016/7/21.
 */
public interface MessageDAO {

    /**
     * 当有人回答了我的问题，为我的问题或者回答点赞，评论我的问题或者回答时 ，通知我
     * @param type
     * @param scrId    事件源ID，包括问题ID 和 回答ID
     * @param sender
     * @param receiver
     */
    void sendMessage(MesType type , Long scrId , User sender , User receiver );


    void save(Message mes);

    long save_id(Message mes);

    Message save_Message(Message mes);

    boolean markChecked(Message mes);

    boolean markChecked(Long mesID);

    void deleteByMesID(Long mesID);


}
