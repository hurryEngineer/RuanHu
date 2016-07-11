package edu.nju.modelService;

import edu.nju.model.Users;

/**
 * Created by cuihao on 2016/7/11.
 */
public interface LoginService {

    public Users verifyLogin(String account, String password);

}
