package edu.nju.logic.impl;

import edu.nju.data.dao.*;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.data.entity.Vote;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;
import edu.nju.data.util.MesType;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.InviteService;
import edu.nju.logic.service.QuestionService;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dora on 2016/7/13.
 */
@Component
public class QuestionImpl implements QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    @Autowired
    AnswerDAO answerDAO;

    @Autowired
    VoteDAO voteDAO;

    @Autowired
    MessageDAO messageDAO;

    @Autowired
    TransferService timeService;

    @Autowired
    InviteService inviteService;

    @Autowired
    WikiDAO wikiDAO;

    @Autowired
    DocumentDAO documentDAO;

    @Autowired
    UserDAO userDAO;

    @Override
    public QuestionVO showQuestion(long id, long userId) {
        Question question = questionDAO.getQuestionByID(id);
        return timeService.transferQuestion(question,userId);
    }

    @Override
    public QuestionVO saveQuestion(Question question, long userId, List wikiIds, List docIds, List<String> inviteNames) {
        QuestionVO questionVO =  timeService.transferQuestion(questionDAO.createQuestion(question,wikiIds,docIds),userId);
        inviteService.inivite(question.getId(), userId, inviteNames);
        return questionVO;
    }

    @Override
    public boolean updateQustion(long questionId, String title, String description) {
        Question question = questionDAO.getQuestionByID(questionId);
        question.setTitle(title);
        question.setContent(description);
        questionDAO.update(question);
        return true;
    }

    @Override
    public List<QuestionVO> getQuestions(int pageNum, int pageSize, long userId) {
        List<Question> questions = questionDAO.getOrderedPagedQuestions
                (pageNum, pageSize, OrderByPara.createdAt, OrderByMethod.DESC );
        List<QuestionVO> questionVOs = new ArrayList<>(questions.size());
        for (Question question : questions) {
            questionVOs.add(timeService.transferQuestion(question,userId));
        }
        return questionVOs;
    }

    @Override
    public boolean deleteQuestion(long questionId, long userId) {
        Question question = questionDAO.getQuestionByID(questionId);
        if (question.getAuthor()!=null && question.getAuthor().getId()!=userId)
            return false;
        questionDAO.deleteByQuestionID(questionId);
        return true;
    }

    @Override
    public List<AnswerVO> getAnswers(long questionId, int pageNum, int pageSize, long userId) {
        List<Answer> answers =  answerDAO.getOrderedPagedAnswersBy
                (WherePara.questionID , questionId , pageNum ,pageSize ,OrderByPara.lastUpdatedAt,OrderByMethod.DESC);
        List<AnswerVO> answerVOs = new ArrayList<>(answers.size());
        for (Answer answer: answers) {
            answerVOs.add(timeService.transferAnswer(answer,userId));
        }
        return answerVOs;
    }

    @Override
    public int vote(String questionId, String userId, VoteType type) {
        Vote vote = new Vote();
        vote.setAuthorId(Long.valueOf(userId));
        vote.setCreatedAt(new Timestamp(new Date().getTime()));
        vote.setLastUpdatedAt(new Timestamp(new Date().getTime()));
        vote.setQuestionId(Long.valueOf(questionId));
        vote.setVoteType(type);
        if (type==VoteType.up && voteDAO.hasVoteQuestion(Long.valueOf(userId),Long.valueOf(questionId))==0) {
            Question question = questionDAO.getQuestionByID(Long.valueOf(questionId));
            User sender = userDAO.getUserByID(Long.valueOf(userId));
            messageDAO.sendMessage(MesType.voteQuestion, question.getId(), sender, question.getAuthor());
        }
        return voteDAO.vote(vote);
    }

}
