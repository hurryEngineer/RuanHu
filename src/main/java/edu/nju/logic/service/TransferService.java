package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;

/**
 * 将entity转成vo
 */
public interface TransferService {
    QuestionVO transferQuestion(Question question);
    AnswerVO transferAnswer(Answer answer);
}
