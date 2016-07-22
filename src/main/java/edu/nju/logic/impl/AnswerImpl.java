package edu.nju.logic.impl;

import edu.nju.data.dao.*;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.data.entity.Vote;
import edu.nju.data.util.MesType;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.AnswerService;
import edu.nju.logic.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by cuihao on 2016/7/13.
 */
@Component
public class AnswerImpl implements AnswerService {

    @Autowired
    private AnswerDAO answerDAO;

    @Autowired
    private VoteDAO voteDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Override
    public boolean markAsSolution(User user, long questionId, long answerId) {
        Question question = questionDAO.getQuestionByID(questionId);
        if (question == null) return false;
        User user1 = question.getAuthor();
        if (user.getId()==user1.getId()) {
//            answerDAO.setSolution(questionId, answerId);
            return true;
        }
        return false;
    }

    @Override
    public boolean saveAnswer(long questionId, long userId, String text, List wikiIds, List docIds) {
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setAuthorId(userId);
        answer.setContent(text);
        answer.setCreatedAt(new Timestamp(new Date().getTime()));
        answer.setLastUpdatedAt(new Timestamp(new Date().getTime()));
        answerDAO.createAnswer(answer, wikiIds, docIds);
        Question question = answer.getQuestion();
        User sender = userDAO.getUserByID(userId);
        messageDAO.sendMessage(MesType.answer,questionId,sender,question.getAuthor());
        return true;
    }

    @Override
    public boolean editAnswer(long answerId, String text) {
        Answer answer = answerDAO.getAnswerByID(answerId);
        answer.setContent(text);
        answerDAO.update(answer);
        return true;
    }

    @Override
    public boolean deleteAnswer(long answerId, long userId) {
        Answer answer = answerDAO.getAnswerByID(answerId);
        if (answer.getAuthor()!=null && answer.getAuthor().getId()!=userId) {
            return false;
        }
        answerDAO.deleteByAnswerID(answerId);
        return true;
    }

    @Override
    public Answer getAnswer(long answerId) {
        return answerDAO.getAnswerByID(answerId);
    }

    @Override
    public int vote(String questionId, String answerId, String userId, VoteType type) {
        Vote vote = new Vote();
        vote.setVoteType(type);
        vote.setAnswerId(Long.valueOf(answerId));
        vote.setAuthorId(Long.valueOf(userId));
        vote.setCreatedAt(new Timestamp(new Date().getTime()));
        vote.setLastUpdatedAt(new Timestamp(new Date().getTime()));
        Answer answer = answerDAO.getAnswerByID(Long.valueOf(answerId));
        User sender = userDAO.getUserByID(Long.valueOf(userId));
        messageDAO.sendMessage(MesType.voteAnswer, answer.getId(), sender, answer.getAuthor());
        return voteDAO.vote(vote);
    }

}
