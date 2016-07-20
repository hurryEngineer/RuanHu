package edu.nju.data.dao;

import java.util.List;


/**
 * Created by Dora on 2016/7/20.
 */
public interface WikiDAO {

    /**
     * 根据wikiID获取与之相关的问题ID
     * @param wikiID
     * @return
     */
    List getRelatedQuestions(long wikiID);


    /**
     * 根据wikiID获取与之相关的文件ID
     * @param wikiID
     * @return
     */
    List getRelatedDocuments(long wikiID);

    /**
     * 插入与某一个问题相关的一系列wiki条目
     * @param questionID
     * @param wikiIDs
     */
    void insertQuestion(long questionID , List wikiIDs);

    /**
     * 插入与某一个回答相关的一系列wiki条目
     * @param answerID
     * @param wikiIDs
     */
    void insertAnswer(long answerID , List wikiIDs);

}
