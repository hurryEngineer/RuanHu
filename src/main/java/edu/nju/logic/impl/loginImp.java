package edu.nju.logic.impl;

import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.Users;
import edu.nju.data.util.VerifyResult;
import edu.nju.logic.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登陆实现
 * @author cuihao
 * @see edu.nju.logic.service.LoginService
 */
@Component
public class LoginImp implements LoginService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public VerifyResult verifyLogin(String account, String password) {
        return userDAO.login(account,password);
    }

    @Override
    public Users getCurrentUser(String account) {
        return userDAO.getUserByName(account);
    }
}
