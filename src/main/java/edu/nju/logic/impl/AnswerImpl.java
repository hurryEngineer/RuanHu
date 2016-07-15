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
            answerDAO.setSolution(answerId);
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
    public void vote(String questionId, String answerId, String userId, VoteType type) {
        Vote vote = new Vote();
        vote.setVoteType(type);
        vote.setQuestionId(Long.valueOf(questionId));
        vote.setAnswerId(Long.valueOf(answerId));
        vote.setAuthorId(Long.valueOf(userId));
        vote.setCreatedAt(new Timestamp(new Date().getTime()));
        vote.setLastUpdatedAt(new Timestamp(new Date().getTime()));
        voteDAO.save(vote);
    }

    @Override
    public void unVote(String questionId, String answerId, String userId, VoteType type) {
        Vote vote = new Vote();
        vote.setVoteType(type);
        vote.setQuestionId(Long.valueOf(questionId));
        vote.setAnswerId(Long.valueOf(answerId));
        vote.setAuthorId(Long.valueOf(userId));
        vote.setCreatedAt(new Timestamp(new Date().getTime()));
        vote.setLastUpdatedAt(new Timestamp(new Date().getTime()));
        voteDAO.cancel(vote);
    }
}
