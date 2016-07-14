package edu.nju.logic.impl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;


/**
 * Created by cuihao on 2016/7/12.
 */
@Component
public class UserProfileImpl implements UserProfileService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public boolean editProfile(User user, String description, String location, String bitrhday) {
        user.setDescription(description);
        user.setLocation(location);
        user.setBirthDate(Date.valueOf(bitrhday));
        userDAO.update(user);
        return true;
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    @Override
    public long getQuestionCountByName(String name) {
        return questionDAO.getQuestionCountByUsername(name);
    }

    @Override
    public long getAnswerCountByName(String name) {
        return answerDAO.getAnswerCountByUserName(name);
    }

    @Override
    public List<Question> getQuestionByName(String name) {
        return questionDAO.getQuestionByUsername(name);
    }

    @Override
    public List<Answer> getAnswerByName(String name) {
        return answerDAO.getAnswerByUserName(name);
    }
}
