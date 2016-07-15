package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.util.VoteType;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;

import java.util.List;

/**
 * Created by Dora on 2016/7/13.
 */
public interface QuestionService {

    QuestionVO showQuestion(long ID);


    QuestionVO saveQuestion(Question question);


    List<QuestionVO> getQuestions(int pageNum, int pageSize);

    /**
     * 根据问题查找答案
     * @param questionId 问题id
     * @param pageNum 页号
     * @param pageSize 页的大小
     * @return 答案列表
     */
    List<AnswerVO> getAnswers(long questionId, int pageNum, int pageSize);

    void vote(String questionId, String userId, VoteType type);

    void unVote(String questionId, String userId, VoteType type);
}
