package edu.nju.logic.impl;

import edu.nju.data.dao.AnswerDAO;
import edu.nju.data.dao.QuestionDAO;
import edu.nju.data.dao.VoteDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.data.entity.Vote;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.AnswerService;
import edu.nju.logic.vo.AnswerVO;
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
    private VoteDAO voteDAO;

    @Autowired
    private QuestionDAO questionDAO;

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
        return voteDAO.vote(vote);
    }

}
