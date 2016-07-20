package edu.nju.data.dao;

import java.util.List;

/**
 * Created by ss14 on 2016/7/20.
 */
public interface DocumentDAO {

    List getRelatedWikis(long docuID );

    List getRelatedQuestions(long docuID);

    /**
     * 插入与某一个问题相关的一系列docu条目
     * @param questionID
     * @param docuIDs
     */
    void insertQuestion(long questionID , List docuIDs);

    /**
     * 插入与某一个回答相关的一系列docu条目
     * @param answerID
     * @param docuIDs
     */
    void insertAnswer(long answerID , List docuIDs);

}
