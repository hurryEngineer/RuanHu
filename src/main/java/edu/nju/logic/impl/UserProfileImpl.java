package edu.nju.logic.impl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.service.UserProfileService;
import edu.nju.logic.vo.ActivityType;
import edu.nju.logic.vo.ActivityVO;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
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
    @Autowired
    private TimeService timeService;

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
    public List<QuestionVO> getQuestionByName(String name) {
        List<Question> questions = questionDAO.getQuestionByUsername(name);
        List<QuestionVO> questionVOs = new ArrayList<>();
        for (Question question : questions) {
            questionVOs.add(timeService.transferQuestion(question));
        }
        return questionVOs;
    }

    @Override
    public List<AnswerVO> getAnswerByName(String name) {
        List<Answer> answers =  answerDAO.getAnswerByUserName(name);
        List<AnswerVO> answerVOs = new ArrayList<>();
        for (Answer answer: answers) {
            answerVOs.add(timeService.transferAnswer(answer));
        }
        return answerVOs;
    }

    @Override
    public List<ActivityVO> orderedActivity(List<QuestionVO> questionVOs, List<AnswerVO> answerVOs) {
        List<ActivityVO> activityVOs = new ArrayList<>();
        for (QuestionVO questionVO: questionVOs) {
            ActivityVO activityVO = new ActivityVO(questionVO);
            activityVOs.add(activityVO);
        }
        for (AnswerVO answerVO: answerVOs) {
            ActivityVO activityVO = new ActivityVO(answerVO);
            activityVOs.add(activityVO);
        }
        Collections.sort(activityVOs);
        return activityVOs;
    }
}
