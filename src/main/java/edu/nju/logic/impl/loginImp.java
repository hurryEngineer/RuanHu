package edu.nju.logic.impl;

import edu.nju.data.entity.Users;
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
    public Users verifyLogin(String account, String password) {
        return null;
    }
}
