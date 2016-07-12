package edu.nju.logic.impl;

import edu.nju.data.entity.Users;
import edu.nju.logic.service.LoginService;

import org.springframework.stereotype.Component;

/**
 * Created by cuihao on 2016/7/11.
 */
@Component
public class loginImp implements LoginService{
    @Override
    public Users verifyLogin(String account, String password) {
        return null;
    }
}
