package edu.nju.data.dao;

import edu.nju.data.entity.Message;

/**
 * Created by ss14 on 2016/7/21.
 */
public interface MessageDAO {


    void save(Message mes);

    long save_id(Message mes);

    Message save_Message(Message mes);

    boolean markChecked(Message mes);

    boolean markChecked(Long mesID);

    void deleteByMesID(Long mesID);



}
