package edu.nju.logic.vo;

import edu.nju.data.entity.Question;

/**
 * Created by cuihao on 2016/7/14.
 */
public class QuestionVO extends Question implements ViewTime {

    private String createAtForView;
    private String updateAtForView;
    private int isVote;

    public QuestionVO(Question question){
        this.setId(question.getId());
        this.setCreatedAt(question.getCreatedAt());
        this.setLastUpdatedAt(question.getLastUpdatedAt());
        this.setAnswerCount(question.getAnswerCount());
        this.setAuthor(question.getAuthor());
        this.setCommentList(question.getCommentList());
        this.setContent(question.getContent());
        this.setAuthorId(question.getAuthorId());
        this.setTitle(question.getTitle());
        this.setViewCount(question.getViewCount());
        this.setVoteCount(question.getVoteCount());
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

    public int isVote() {
        return isVote;
    }

    public void setVote(int vote) {
        this.isVote = vote;
    }
}
