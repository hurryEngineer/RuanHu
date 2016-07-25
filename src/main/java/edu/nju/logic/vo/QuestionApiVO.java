package edu.nju.logic.vo;

import edu.nju.data.entity.Question;
import edu.nju.logic.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cuihao on 2016/7/25.
 */
public class QuestionApiVO {
    private long questionId;
    private long userId;
    private String userName;
    private String avaUrl;
    private String title;
    private String content;
    private String questionUrl;
    private String createAt;
    private String updateAt;

    public QuestionApiVO(Question question) {
        this.questionId = question.getId();
        this.userId = question.getAuthorId();
        this.userName = question.getAuthor().getUserName();
        this.avaUrl = question.getAuthor().getPhotoUri();
        this.title = question.getTitle();
        this.content = question.getContent();
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvaUrl() {
        return avaUrl;
    }

    public void setAvaUrl(String avaUrl) {
        this.avaUrl = avaUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestionUrl() {
        return questionUrl;
    }

    public void setQuestionUrl(String questionUrl) {
        this.questionUrl = questionUrl;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
