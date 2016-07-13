package edu.nju.logic.impl;

import edu.nju.data.entity.User;
import edu.nju.logic.service.AnswerService;
import org.springframework.stereotype.Component;

/**
 * Created by cuihao on 2016/7/13.
 */
@Component
public class AnswerImpl implements AnswerService {
    @Override
    public boolean markAsSolution(User user, long questionId, long answerId) {
        return false;
    }

    @Override
    public boolean saveAnswer(long questionId, long userId, String text) {
        return false;
    }
}
