package edu.nju.logic.impl;

import edu.nju.data.dao.VoteDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cuihao on 2016/7/20.
 */
@Component
public class TransferImpl implements TransferService {

    @Autowired
    private TimeService timeService;

    @Autowired
    private VoteDAO voteDAO;

    @Override
    public QuestionVO transferQuestion(Question question, long userId) {
        QuestionVO questionVO = new QuestionVO(question);
        if (question.getCreatedAt()!=null)
            questionVO.setCreateAtForView(timeService.timeToString(question.getCreatedAt()));
        if (question.getLastUpdatedAt()!=null)
            questionVO.setUpdateAtForView(timeService.timeToString(question.getLastUpdatedAt()));
        int vote = 0;
        if (userId>=0) {
            if (voteDAO.hasVoteQuestion(userId,question.getId(), VoteType.up)) {
                vote = 1;
            } else if (voteDAO.hasVoteQuestion(userId, question.getId(), VoteType.down)) {
                vote = -1;
            }
        }
        questionVO.setVote(vote);
        return questionVO;
    }

    @Override
    public AnswerVO transferAnswer(Answer answer, long userId) {
        AnswerVO answerVO = new AnswerVO(answer);
        if (answer.getCreatedAt()!=null)
            answerVO.setCreateAtForView(timeService.timeToString(answer.getCreatedAt()));
        if (answer.getLastUpdatedAt()!=null)
            answerVO.setUpdateAtForView(timeService.timeToString(answer.getLastUpdatedAt()));
        int vote = 0;
        if (userId>=0) {
            if (voteDAO.hasVoteAnswer(userId, answer.getId(), VoteType.up)) {
                vote = 1;
            } else if (voteDAO.hasVoteAnswer(userId, answer.getId(), VoteType.down)) {
                vote = -1;
            }
        }
        answerVO.setVote(vote);
        return answerVO;
    }
}
