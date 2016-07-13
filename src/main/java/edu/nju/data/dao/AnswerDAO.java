package edu.nju.data.dao;

import edu.nju.data.entity.Answer;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface AnswerDAO {

    /**
     * 保存一个回答对象
     * @param answer
     */
    void save(Answer answer);

    void deleteByAnswerID(long AnswerID);
}
