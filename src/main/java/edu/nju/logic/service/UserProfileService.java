package edu.nju.logic.service;

import edu.nju.data.entity.User;

/**
 * 用户个人信息接口
 * @author cuihao
 */
public interface UserProfileService {
    /**
     * 更新用户的个人信息
     * @param user 登陆后保存在session里的用户类
     * @param description 用户更新后的个人描述
     * @param location 用户更新后的地址
     * @param bitrhday 用户更新后的生日
     * @return 是否更新成功
     */
    boolean editProfile(User user, String description, String location, String bitrhday);

}
