package edu.nju.logic.vo;

import edu.nju.data.entity.User;

/**
 * Created by cuihao on 2016/7/22.
 */
public class UserVO extends User {
    public UserVO(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setLocation(user.getLocation());
        this.setUserName(user.getUserName());
        this.setPhotoUri(user.getPhotoUri());
        this.setBirthDate(user.getBirthDate());
        this.setDescription(user.getDescription());
        this.setCreatedAt(user.getCreatedAt());
    }
}
