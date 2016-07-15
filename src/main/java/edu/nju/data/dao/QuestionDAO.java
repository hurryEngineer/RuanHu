package edu.nju.data.dao;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;

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
     * 根据某个属性来筛选Answer,不排序，不分页
     * @param byPara   WherePara : userID , userName , questionID
     * @param para     where 参数
     * @return
     */
    List<Question>  getQuestionBy(WherePara byPara , Object para);

    /**
     * 获取分页的问题列表，不排序
     * @param pageNum
     * @return
     */
    List<Question>  getPagedQuestions(int pageNum );
    List<Question>  getPagedQuestions(int pageNum ,int pageSize);

    /**
     * 获取排序后的分页列表
     * @param pageNum
     * @param orderByPara  排序参数
     * @return
     */
    List<Question>  getOrderedPagedQuestions(int pageNum , OrderByPara orderByPara);
    List<Question>  getOrderedPagedQuestions(int pageNum ,int pageSize, OrderByPara orderByPara ,OrderByMethod orderByMethod);

    /**
     * 获取根据wherepara删选后的，排序后的分页列表
     * @param byPara
     * @param para
     * @param pageNum
     * @param orderByPara
     * @return
     */
    List<Question>  getOrderedPagedQuestionsBy(WherePara byPara , Object para , int pageNum , OrderByPara orderByPara);
    List<Question>  getOrderedPagedQuestionsBy(WherePara byPara , Object para , int pageNum ,int pageSize, OrderByPara orderByPara ,OrderByMethod orderByMethod);




    /**
     * 获取全部问题
     * @return
     */
    List<Question> getAllQuestions();


    /**
     * 根据用户名获取该用户的全部问题的数目
     * @param username
     * @return
     */
    long getQuestionCountByUsername(String username);


    /**
     * 根据用户ID获取用户的全部问题的数目
     * @param userID
     * @return
     */
    long getQuestionCountByUserID(long userID);



}
