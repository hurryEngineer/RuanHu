package edu.nju.logic.service;


import edu.nju.data.util.VerifyResult;


/**
 * 登陆接口
 * @author cuihao
 */
public interface LoginService {

    /**
     * 验证登陆信息
     * @param account  登陆账号
     * @param password   密码
     * @return  返回查找状态 {@link VerifyResult}
     */
    VerifyResult verifyLogin(String account, String password);

    /**
     * 获取用户信息： 在验证后调用
     * @param account 账号
     * @return 用户具体信息 {@link User}
     */
    User getCurrentUser(String account);

}
