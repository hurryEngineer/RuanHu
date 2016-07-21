package edu.nju.data.dao;

import edu.nju.data.entity.User;

import java.util.List;

/**
 * Created by ss14 on 2016/7/21.
 */
public interface inviteDAO {

    /**
     * 保存邀请信息到数据库
     * @param srcId      事件源，目前只有问题ID
     * @param sender     发送者
     * @param receivers  接收者
     */
    void invite(Long srcId , User sender , List<User> receivers);


}
