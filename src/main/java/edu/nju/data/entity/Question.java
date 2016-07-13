package edu.nju.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ss14 on 2016/7/12.
 */
@Entity
public class Question {
    private long id;
    private long answerCount;
    private long voteCount;
    private long viewCount;
    private Long authorId;
    private String title;
    private String content;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;

    @Id
    @Column(name = "id")
    @GeneratedValue //How do i correct this to have multiple rows with same id and different subid**
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "answer_count")
    public long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(long answerCount) {
        this.answerCount = answerCount;
    }

    @Basic
    @Column(name = "vote_count")
    public long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }

    @Basic
    @Column(name = "view_count")
    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "author_id")
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "last_updated_at")
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (answerCount != question.answerCount) return false;
        if (voteCount != question.voteCount) return false;
        if (viewCount != question.viewCount) return false;
        if (authorId != null ? !authorId.equals(question.authorId) : question.authorId != null) return false;
        if (title != null ? !title.equals(question.title) : question.title != null) return false;
        if (content != null ? !content.equals(question.content) : question.content != null) return false;
        if (createdAt != null ? !createdAt.equals(question.createdAt) : question.createdAt != null) return false;
        if (lastUpdatedAt != null ? !lastUpdatedAt.equals(question.lastUpdatedAt) : question.lastUpdatedAt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (answerCount ^ (answerCount >>> 32));
        result = 31 * result + (int) (voteCount ^ (voteCount >>> 32));
        result = 31 * result + (int) (viewCount ^ (viewCount >>> 32));
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lastUpdatedAt != null ? lastUpdatedAt.hashCode() : 0);
        return result;
    }
}
