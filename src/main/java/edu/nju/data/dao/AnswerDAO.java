package edu.nju.data.dao;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;

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
     * 保存一个带引用的回答
     * @param answer
     * @param wikiIDs  如果该回答没有引用wiki条目则应该为null
     * @param DocuIDs  如果该回答没有引用文件则应该为null
     * @return
     */
    Answer createAnswer(Answer answer ,List wikiIDs , List DocuIDs);


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
     * 把一个问题Solution标志置0
     * @param answerID
     */
    void cancelSolution(long answerID);


    /**
     * 根据AnswerID获取Answer
     * @param answerID
     * @return
     */
    Answer getAnswerByID(long answerID);


    /**
     * 根据某个属性来筛选Answer,不排序，不分页
     * @param byPara   WherePara : userID , userName , questionID
     * @param para     where 参数
     * @return
     */
    List<Answer>  getAnswerBy(WherePara byPara , Object para);

    /**
     * 获取分页的回答列表，不排序
     * @param pageNum
     * @return
     */
    List<Answer>  getPagedAnswers(int pageNum );
    List<Answer>  getPagedAnswers(int pageNum ,int pageSize);

    /**
     * 获取排序后的分页列表
     * @param pageNum
     * @param orderByPara  排序参数
     * @return
     */
    List<Answer>  getOrderedPagedAnswers(int pageNum , OrderByPara orderByPara);
    List<Answer>  getOrderedPagedAnswers(int pageNum ,int pageSize, OrderByPara orderByPara ,OrderByMethod orderByMethod);

    /**
     * 获取根据wherepara删选后的，排序后的分页列表
     * @param byPara
     * @param para
     * @param pageNum
     * @param orderByPara
     * @return
     */
    List<Answer>  getOrderedPagedAnswersBy(WherePara byPara , Object para , int pageNum , OrderByPara orderByPara);
    List<Answer>  getOrderedPagedAnswersBy(WherePara byPara , Object para , int pageNum ,int pageSize, OrderByPara orderByPara ,OrderByMethod orderByMethod);



    /**
     * 根据用户名，返回一个用户的全部回答数目
     * @param username
     */
    long getAnswerCountByUserName(String username);

    /**
     * 根据用户ID，返回一个用户提出的全部回答的数目
     * @param ID
     */
    long getAnswerCountByUserID(long ID);


    List<WikiItem> getRelatedWikiID(long QuestionID);

    List<Document> getRelatedDocuID(long QuestionID);

}
