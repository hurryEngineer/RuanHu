package edu.nju.logic.impl;

import edu.nju.data.dao.InviteDAO;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import edu.nju.logic.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/7/21.
 */
@Component
public class InviteImpl implements InviteService {

    @Autowired
    private InviteDAO inviteDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void inivite(long questionId, long userId, List<String> inviteNames) {
        User sender = userDAO.getUserByID(userId);
        if (inviteNames!=null && inviteNames.size()>0) {
            List<User> users = new ArrayList<>();
            for (String inviteName: inviteNames) {
                User user = userDAO.getUserByName(inviteName);
                if (user!=null)
                    users.add(user);
            }
            inviteDAO.invite(questionId, sender, users);
        }
    }
}
