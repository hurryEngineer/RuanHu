package edu.nju.data.dao;

import edu.nju.data.entity.Answer;
import edu.nju.data.util.OrderByMethod;
import edu.nju.data.util.OrderByPara;

import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface AnswerDAO {

    /**
     * 保存一个回答对象
     * @param answer
     */
    void save(Answer answer);

    /**
     * 保存一个回答对象,并返回新的ID
     * @param answer
     * @return
     */
    long save_id(Answer answer);

    /**
     * 保存一个回答对象,并返回新的对象
     * @param answer
     * @return
     */
    Answer save_answer(Answer answer);


    /**
     * 根据AnswerID删除问题
     * @param answerID
     */
    void deleteByAnswerID(long answerID);

    /**
     * 根据QuestionID删除某个问题的全部回答
     * 删除某个问题时需要用到级联删除
     * @param questionID
     * @return
     */
    int deleteByQuestionID(long questionID);

    /**
     * 根据UserID删除某个用户的全部回答
     * 删除某个用户时可能需要用到
     * @param userID
     * @return
     */
    int deleteByUserID(long userID);

    /**
     * 删除某个问题由某个用户回答的全部答案
     * @param questionID
     * @param userID
     * @return
     */
    int deleteByQuestion_UserID(long questionID, long userID);

    /**
     * 更新一个Answer条目，至少ID,authorID,questionID 被赋值
     * @param answer
     */
    void update(Answer answer);

    /**
     * 把一个Answer选为solution
     * @param answerID
     * @param questionID
     */
    void setSolution(long questionID ,long answerID);

    /**
     * 根据AnswerID获取Answer
     * @param answerID
     * @return
     */
    Answer getAnswerByID(long answerID);

    /**
     * 获取全部的回答
     * @param questionID
     * @return
     */
    List<Answer> getAnswerByQuestionID(long questionID);

    /**
     * 不排序
     * 获取某页的回答，页面大小默认是10
     * @param questionID
     * @param pageNum
     * @return
     */
    List<Answer> getAnswerByQuestionID(long questionID , int pageNum);

    /**
     * 不排序
     * 获取某页的回答，自定义页面大小
     * @param questionID
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Answer> getAnswerByQuestionID(long questionID , int pageNum ,int pageSize);

    /**
     * 根据参数排序，默认降序
     * @param questionID
     * @param pageNum
     * @param para
     * @return
     */
    List<Answer> getAnswerByQuestionID(long questionID , int pageNum , OrderByPara para);

    /**
     * 根据参数排序，默认降序
     * @param questionID
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Answer> getAnswerByQuestionID(long questionID , int pageNum ,int pageSize ,OrderByPara para);

    /**
     * 根据参数和排序方式，进行排序
     * @param questionID
     * @param pageNum
     * @param para
     * @param method
     * @return
     */
    List<Answer> getAnswerByQuestionID
        (long questionID , int pageNum , OrderByPara para , OrderByMethod method);

    /**
     *  根据参数和排序方式，进行排序
     * @param questionID
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Answer> getAnswerByQuestionID
        (long questionID , int pageNum ,int pageSize ,OrderByPara para ,OrderByMethod method);




    /**
     * 根据用户名,返回一个用户的全部问题列表
     * @param username
     */
    List<Answer> getAnswerByUserName(String username);

    /**
     * 根据用户名，返回一个用户的全部问题数目
     * @param username
     */
    long getAnswerCountByUserName(String username);

    /**
     * 根据用户ID，返回一个用户提出的全部问题列表
     * @param ID
     */
    List<Answer> getAnswerByUserID(long ID);

    /**
     * 根据用户ID，返回一个用户提出的全部问题的数目
     * @param ID
     */
    long getAnswerCountByUserID(long ID);



}
