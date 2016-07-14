package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;

import java.sql.Timestamp;

/**
 * Created by cuihao on 2016/7/14.
 */
public interface TimeService {
    String timeToString(Timestamp timestamp);
    QuestionVO transferQuestion(Question question);
    AnswerVO transferAnswer(Answer answer);
}
