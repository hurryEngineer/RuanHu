package edu.nju.logic.vo;

import edu.nju.data.entity.Answer;

/**
 * Created by cuihao on 2016/7/14.
 */
public class AnswerVO extends Answer implements ViewTime{
    private String createAtForView;
    private String updateAtForView;

    public AnswerVO(Answer answer) {
        this.setAuthor(answer.getAuthor());
        this.setAuthorId(answer.getAuthorId());
        this.setCreatedAt(answer.getCreatedAt());
        this.setLastUpdatedAt(answer.getLastUpdatedAt());
        this.setId(answer.getId());
        this.setVoteCount(answer.getVoteCount());
        this.setContent(answer.getContent());
        this.setCommentList(answer.getCommentList());
        this.setSolution(answer.getSolution());
        this.setQuestionId(answer.getQuestionId());
    }

    @Override
    public String getCreateAtForView() {
        return createAtForView;
    }

    public void setCreateAtForView(String createAtForView) {
        this.createAtForView = createAtForView;
    }

    @Override
    public String getUpdateAtForView() {
        return updateAtForView;
    }

    public void setUpdateAtForView(String updateAtForView) {
        this.updateAtForView = updateAtForView;
    }



}
