package edu.nju.logic.vo;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.WikiItem;

import java.util.List;

/**
 * Created by cuihao on 2016/7/14.
 */
public class AnswerVO extends Answer implements ViewTime{
    private String createAtForView;
    private String updateAtForView;
    private int isVote;
    private List<WikiItem> wikiItems;
    private List<Document> documents;

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

    public int getIsVote() {
        return isVote;
    }

    public void setIsVote(int isVote) {
        this.isVote = isVote;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<WikiItem> getWikiItems() {
        return wikiItems;
    }

    public void setWikiItems(List<WikiItem> wikiItems) {
        this.wikiItems = wikiItems;
    }

    @Override
    public String toString() {
        return "AnswerVO{" +
                "createAtForView='" + createAtForView + '\'' +
                ", updateAtForView='" + updateAtForView + '\'' +
                ", isVote=" + isVote +
                ", wikiItems=" + wikiItems +
                ", documents=" + documents +
                "} " + super.toString();
    }
}
