package edu.nju.model.login;

import edu.nju.modelService.LoginService;
import org.springframework.stereotype.Component;

/**
 * Created by cuihao on 2016/7/11.
 */
@Component
public class loginImp implements LoginService{
    @Override
    public String verifyLogin(String account, String password) {
        return null;
    }
}