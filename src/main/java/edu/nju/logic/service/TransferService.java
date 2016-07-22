package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.Question;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.MessageVO;
import edu.nju.logic.vo.QuestionVO;

import java.util.List;

/**
 * 将entity转成vo
 */
public interface TransferService {
    QuestionVO transferQuestion(Question question, long userId);
    AnswerVO transferAnswer(Answer answer, long userId);
    List<MessageVO> transferMessage(List<Message> message);
}
