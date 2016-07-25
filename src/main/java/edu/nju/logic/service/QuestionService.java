package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.util.VoteType;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionApiVO;
import edu.nju.logic.vo.QuestionVO;

import java.util.List;

/**
 * Created by Dora on 2016/7/13.
 */
public interface QuestionService {

    QuestionApiVO getApiQuestion(long questionId);

    QuestionVO showQuestion(long ID, long userId);

    QuestionVO saveQuestion(Question question, long userId, List wikiIds, List docIds, List<Long> iniviteNames);

    boolean updateQustion(long questionId, String title, String description);

    List<QuestionVO> getQuestions(int pageNum, int pageSize, long userId);

    /**
     * 删除问题
     * @param questionId 问题id
     * @param userId 回答id
     * @return 是否有权限删除
     */
    boolean deleteQuestion(long questionId, long userId);

    /**
     * 根据问题查找答案
     * @param questionId 问题id
     * @param pageNum 页号
     * @param pageSize 页的大小
     * @return 答案列表
     */
    List<AnswerVO> getAnswers(long questionId, int pageNum, int pageSize, long userId);

    /**
     * 为回答投票
     * @param questionId 问题id
     * @param userId 用户id
     * @param type 赞同或反对
     * @return 如果之前没有投过赞同票，票数增加1，返回 1
     *          如果之前投过赞同票，票数减少1， 返回 -1
     *          如果之前投的反对票，票数增加2，返回 2
     */
    int vote(String questionId, String userId, VoteType type);

}
