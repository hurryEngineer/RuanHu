package edu.nju.logic.impl;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.service.AuthService;
import org.springframework.stereotype.Component;

/**
 * Created by cuihao on 2016/7/25.
 */
@Component
public class AuthServiceImpl implements AuthService {
    @Override
    public boolean canEditQuestion(long user, Question question) {
        return user == question.getAuthorId();
    }

    @Override
    public boolean canDeleteQuestion(long user, Question question) {
        return user == question.getAuthorId();
    }

    @Override
    public boolean canEditAnswer(long user, Answer answer) {
        return user == answer.getAuthorId().longValue();
    }

    @Override
    public boolean canDeleteAnswer(long user, Answer answer) {
        return user == answer.getAuthorId().longValue();
    }
}
