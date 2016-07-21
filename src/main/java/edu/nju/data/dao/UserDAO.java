package edu.nju.data.dao;

import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.Mesg_Helper.MesFactoryInterface;
import edu.nju.data.util.VerifyResult;

import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface UserDAO {


    void save(User user);


    boolean exists(String username);

    boolean verify(String username , String password);

    VerifyResult login(String username, String password);

    User getUserByName(String username);

    User getUserByID(Long id);


    /**
     * 更新用户信息，NOT NULL属性: ID，username,password
     * @param user
     */
    void update(User user);


    List<User> search(String partName);

    List<Message> getAllMessage(Long userID);

}
