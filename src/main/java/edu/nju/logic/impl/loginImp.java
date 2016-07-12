package edu.nju.logic.impl;

import edu.nju.logic.service.LoginService;

import org.springframework.stereotype.Component;

/**
 * 登陆实现
 * @author cuihao
 * @see edu.nju.logic.service.LoginService
 */
@Component
public class loginImp implements LoginService{
    @Override
    public User verifyLogin(String account, String password) {
        return null;
    }
}
