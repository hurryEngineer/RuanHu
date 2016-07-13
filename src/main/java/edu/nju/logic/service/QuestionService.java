package edu.nju.logic.service;

import edu.nju.data.entity.Question;

/**
 * Created by Dora on 2016/7/13.
 */
public interface QuestionService {

    Question showQuestion(long ID);


    Question saveQuestion(Question question);


}
