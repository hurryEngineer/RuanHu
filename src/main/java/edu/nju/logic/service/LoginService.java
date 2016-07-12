package edu.nju.logic.service;

/**
 * 登陆接口
 * @author cuihao
 */
public interface LoginService {

    /**
     * 验证登陆信息
     * @param account  登陆账号
     * @param password   密码
     * @return  如果查找不到，返回null,否则返回对应的{@link User}
     */
    User verifyLogin(String account, String password);

}
