package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.vo.*;

import java.util.List;

/**
 * 将entity转成vo
 */
public interface TransferService {
    QuestionVO transferQuestion(Question question, long userId);
    AnswerVO transferAnswer(Answer answer, long userId);
    List<MessageVO> transferMessage(List<Message> message);
    UserVO transferUser(User user);
    QuestionApiVO transferApiQuestion(Question question);
}
