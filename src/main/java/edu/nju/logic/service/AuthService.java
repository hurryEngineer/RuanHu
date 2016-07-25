package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;

/**
 * Created by cuihao on 2016/7/25.
 */
public interface AuthService {
    boolean canEditQuestion(long user, Question question);
    boolean canDeleteQuestion(long user, Question question);
    boolean canEditAnswer(long user, Answer answer);
    boolean canDeleteAnswer(long user, Answer answer);
}
