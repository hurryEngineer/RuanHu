package edu.nju.data.dao;

import edu.nju.data.entity.Question;

import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface QuestionDAO {

    Question getQuestionByID(long QuestionID);

    List<Question> getQuestionByUsername(String userName);


}
