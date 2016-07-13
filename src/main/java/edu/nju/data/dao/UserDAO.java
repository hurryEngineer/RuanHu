package edu.nju.data.dao;

import edu.nju.data.entity.User;
import edu.nju.data.util.VerifyResult;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface UserDAO {

    boolean exists(String username);

    boolean verify(String username , String password);

    VerifyResult login(String username, String password);

    User getUserByName(String username);


    /**
     * 更新用户信息，NOT NULL属性: ID，username,password
     * @param user
     */
    void update(User user);

}
