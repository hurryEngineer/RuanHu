package edu.nju.data.dao;

import edu.nju.data.entity.Question;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;

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
     * 不排序
     * @param pageNum    当前页号，从1开始,页面大小默认是10
     * @return
     */
    List<Question> getPaginatedQuestions(int pageNum);

    /**
     * 不排序
     * @param pageNum    当前页号，从1开始
     * @param pageSize   页面大小自定
     * @return
     */
    List<Question> getPaginatedQuestions(int pageNum , int pageSize );


    /**
     * 按参数排序,默认降序
     * @param pageNum
     * @param para   OrderByPara: createdAt lastUpdatedAt ....
     * @return
     */
    List<Question> getPaginatedQuestions(int pageNum , OrderByPara para);

    /**
     * 按参数排序，默认降序
     * @param pageNum
     * @param para   OrderByPara: createdAt lastUpdatedAt ....
     * @return
     */
    List<Question> getPaginatedQuestions(int pageNum , int pageSize ,OrderByPara para);


    /**
     * 按参数排序，可选升序降序
     * @param pageNum
     * @param para
     * @param method  OrderByMethod.ASC  DESC
     * @return
     */
    List<Question> getPaginatedQuestions
        (int pageNum , OrderByPara para , OrderByMethod method);

    /**
     * 按参数排序，可选升序降序
     * @param pageNum
     * @param para
     * @param method  OrderByMethod.ASC  DESC
     * @return
     */
    List<Question> getPaginatedQuestions
        (int pageNum , int pageSize ,OrderByPara para ,OrderByMethod method);



    /**
     * 获取全部问题
     * @return
     */
    List<Question> getAllQuestions();


    /**
     * 根据用户名获取该用户的全部问题
     * @param userName
     * @return
     */
    List<Question> getQuestionByUsername(String userName);

    /**
     * 根据用户名获取该用户的全部问题的数目
     * @param username
     * @return
     */
    long getQuestionCountByUsername(String username);

    /**
     *  根据用户ID获取该用户的全部问题
     * @param userID
     * @return
     */
    List<Question> getQuestionByUserID(long userID);

    /**
     * 根据用户ID获取用户的全部问题的数目
     * @param userID
     * @return
     */
    long getQuestionCountByUserID(long userID);



}
