package edu.nju.logic.impl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.service.UserProfileService;
import edu.nju.logic.vo.ActivityType;
import edu.nju.logic.vo.ActivityVO;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;


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
    private TransferService timeService;

    @Override
    public boolean editProfile(User user, String description, String location, String bitrhday) {
        user.setDescription(description);
        user.setLocation(location);
        user.setBirthDate(Date.valueOf(bitrhday));
        userDAO.update(user);
        return true;
    }

    @Override
    public boolean editBirthday(User user, String bitrhday) {
        try {
            String[] strs = bitrhday.split("/");
            bitrhday = strs[2]+"-"+strs[0]+"-"+strs[1];
            user.setBirthDate(Date.valueOf(bitrhday));
            userDAO.update(user);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean editDescription(User user, String description) {
        user.setDescription(description);
        userDAO.update(user);
        return true;
    }

    @Override
    public boolean editLocation(User user, String location) {
        user.setLocation(location);
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
    public List<QuestionVO> getQuestionByName(String userName) {
        List<Question> questions = questionDAO.getOrderedPagedQuestionsBy(WherePara.userName ,userName,1, OrderByPara.createdAt);
        if (questions==null) return new ArrayList<QuestionVO>();
        List<QuestionVO> questionVOs = new ArrayList<>();
        for (Question question : questions) {
            questionVOs.add(timeService.transferQuestion(question));
        }
        return questionVOs;
    }

    @Override
    public List<AnswerVO> getAnswerByName(String userName) {
        List<Answer> answers =  answerDAO.getOrderedPagedAnswersBy(WherePara.userName,userName,1, OrderByPara.createdAt);
        if (answers==null) return new ArrayList<AnswerVO>();
        List<AnswerVO> answerVOs = new ArrayList<>();
        for (Answer answer: answers) {
            answerVOs.add(timeService.transferAnswer(answer));
        }
        return answerVOs;
    }

    @Override
    public List<ActivityVO> orderedActivity(List<QuestionVO> questionVOs, List<AnswerVO> answerVOs) {
        List<ActivityVO> activityVOs = new ArrayList<>();
        if (questionVOs!=null) {
            for (QuestionVO questionVO: questionVOs) {
                ActivityVO activityVO = new ActivityVO(questionVO);
                activityVOs.add(activityVO);
            }
        }
        if (answerVOs!=null) {
            for (AnswerVO answerVO: answerVOs) {
                ActivityVO activityVO = new ActivityVO(answerVO);
                activityVOs.add(activityVO);
            }
        }
        if (activityVOs.size()>0)
            Collections.sort(activityVOs);
        return activityVOs;
    }
}
