package edu.nju.logic.impl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.dao.VoteDAO;
import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.MessageVO;
import edu.nju.logic.vo.QuestionVO;
import edu.nju.logic.vo.UserVO;
import org.aspectj.weaver.ast.ITestVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Component
public class TransferImpl implements TransferService {

    @Autowired
    private TimeService timeService;

    @Autowired
    private VoteDAO voteDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public QuestionVO transferQuestion(Question question, long userId) {
        QuestionVO questionVO = new QuestionVO(question);
        if (question.getCreatedAt()!=null)
            questionVO.setCreateAtForView(timeService.timeToString(question.getCreatedAt()));
        if (question.getLastUpdatedAt()!=null)
            questionVO.setUpdateAtForView(timeService.timeToString(question.getLastUpdatedAt()));
        questionVO.setIsVote(voteDAO.hasVoteQuestion(userId, question.getId()));
        questionVO.setWikiItems(questionDAO.getRelatedWikiItems(question.getId()));
        questionVO.setDocuments(questionDAO.getRelatedDocuments(question.getId()));
        questionVO.setCreateAuthor(question.getAuthor().getId()==userId);
        return questionVO;
    }

    @Override
    public AnswerVO transferAnswer(Answer answer, long userId) {
        AnswerVO answerVO = new AnswerVO(answer);
        if (answer.getCreatedAt()!=null)
            answerVO.setCreateAtForView(timeService.timeToString(answer.getCreatedAt()));
        if (answer.getLastUpdatedAt()!=null)
            answerVO.setUpdateAtForView(timeService.timeToString(answer.getLastUpdatedAt()));
        answerVO.setIsVote(voteDAO.hasVoteAnswer(userId, answer.getId()));
        answerVO.setWikiItems(answerDAO.getRelatedWikiItems(answer.getId()));
        answerVO.setDocuments(answerDAO.getRelatedDocuments(answer.getId()));
        answerVO.setCreateAuthor(answer.getAuthor().getId()==userId);
        return answerVO;
    }

    @Override
    public List<MessageVO> transferMessage(List<Message> messages) {
        List<MessageVO> messageVOs = new ArrayList<>();
        for (Message message: messages) {
            Answer answer = null;
            Question question = null;
            MessageVO messageVO = new MessageVO(message);
            switch (message.getMesgType()) {
                case voteAnswer:
                    answer = answerDAO.getAnswerByID(message.getSourceId());
                    break;
                default:
                    question = questionDAO.getQuestionByID(message.getSourceId());
            }
            messageVO.setAnswer(answer);
            messageVO.setQuestion(question);
            messageVOs.add(messageVO);
        }
        return messageVOs;
    }

    @Override
    public UserVO transferUser(User user) {
        return new UserVO(user);
    }
}
