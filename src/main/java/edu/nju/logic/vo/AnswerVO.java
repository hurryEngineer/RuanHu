package edu.nju.logic.vo;

import edu.nju.data.entity.Answer;

/**
 * Created by cuihao on 2016/7/14.
 */
public class AnswerVO extends Answer implements ViewTime{
    private String createAtForView;
    private String updateAtForView;

    @Override
    public String getCreateAtForView() {
        return null;
    }

    @Override
    public String getUpdateAtForView() {
        return null;
    }
}
