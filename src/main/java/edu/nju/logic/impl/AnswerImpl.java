package edu.nju.logic.impl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.User;
import edu.nju.logic.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cuihao on 2016/7/13.
 */
@Component
public class AnswerImpl implements AnswerService {

    @Autowired
    private AnswerDAO answerDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public boolean markAsSolution(User user, long questionId, long answerId) {
        return false;
    }

    @Override
    public boolean saveAnswer(long questionId, long userId, String text) {
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setAuthorId(userId);
        answer.setContent(text);
        answer.setCreatedAt(new Timestamp(new Date().getTime()));
        answer.setLastUpdatedAt(new Timestamp(new Date().getTime()));
        answerDAO.save(answer);
        return true;
    }
}
