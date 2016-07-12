package edu.nju.logic.impl;

import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import edu.nju.logic.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cuihao on 2016/7/12.
 */
public class UserProfileImpl implements UserProfileService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean editProfile(User user, String description, String location, String bitrhday) {
        return false;
    }
}
