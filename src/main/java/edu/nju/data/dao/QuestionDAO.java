package edu.nju.data.dao;

import edu.nju.data.entity.Question;
import org.springframework.boot.ansi.AnsiElement;

import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface QuestionDAO {

    /**
     * 简单的保存一个问题
     * @param question
     */
    void save(Question question);
    /**
     *  保存一个问题，返回ID
     * @param question
     * @return  id
     */
    long save_id(Question question);

    /**
     *  保存一个问题，返回对象
     * @param question
     * @return  Question
     */
    Question save_question(Question question);


    /**
     * 根据问题ID删除一个问题
     * @param questionID
     */
    void deleteByQuestionID(long questionID);

    /**
     * 删除一个用户的全部问题,返回删除的问题数
     * @param authorID
     */
    int deleteByAuthorID(long authorID);

    /**
     * 更新一个问题
     * @param question  至少ID,AuthorID被赋值
     */
    void update(Question question);

    /**
     * 根据问题ID获取Question对象
     * @param QuestionID
     * @return
     */
    Question getQuestionByID(long QuestionID);


    /**
     * 根据用户名获取该用户的全部问题
     * @param userName
     * @return
     */
    List<Question> getQuestionByUsername(String userName);


}
