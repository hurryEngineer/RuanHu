package edu.nju.logic.impl;

import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import edu.nju.logic.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;


/**
 * Created by cuihao on 2016/7/12.
 */
@Component
public class UserProfileImpl implements UserProfileService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean editProfile(User user, String description, String location, String bitrhday) {
        user.setDescription(description);
        user.setLocation(location);
        user.setBirthDate(Date.valueOf(bitrhday));
        userDAO.update(user);
        return true;
    }
}
