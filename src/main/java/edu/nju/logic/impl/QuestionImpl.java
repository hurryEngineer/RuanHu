package edu.nju.logic.impl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.entity.Question;
import edu.nju.logic.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Dora on 2016/7/13.
 */
@Component
public class QuestionImpl implements QuestionService {

    @Autowired
    QuestionDAO questionDAO;

//    @Autowired 
//    AnswerDAO answerDAO;

    @Override
    public Question showQuestion(long id) {
        Question question = questionDAO.getQuestionByID(id);
        return question;
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionDAO.save_question(question);
    }

    @Override
    public List<Question> getQuestions(int pageNum, int pageSize) {
        return questionDAO.getPaginatedQuestions(pageNum, pageSize);
    }

}
