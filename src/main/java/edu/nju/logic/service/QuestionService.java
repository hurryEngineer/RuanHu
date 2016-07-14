package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;

import java.util.List;

/**
 * Created by Dora on 2016/7/13.
 */
public interface QuestionService {

    Question showQuestion(long ID);


    Question saveQuestion(Question question);


    List<Question> getQuestions(int pageNum, int pageSize);

    /**
     * 根据问题查找答案
     * @param questionId 问题id
     * @param pageNum 页号
     * @param pageSize 页的大小
     * @return 答案列表
     */
    List<Answer> getAnswers(long questionId, int pageNum, int pageSize);
}
