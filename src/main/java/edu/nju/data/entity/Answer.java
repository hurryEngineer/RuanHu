package edu.nju.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ss14 on 2016/7/12.
 */

@Entity
public class Answer {
    private long id;
    private String content;
    private Long authorId;
    private Long questionId;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private Long voteCount;
    private Integer lucky;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "author_id")
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "question_id")
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    @Basic
    @Column(name = "vote_count")
    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    @Basic
    @Column(name = "lucky")
    public Integer getLucky() {
        return lucky;
    }

    public void setLucky(Integer lucky) {
        this.lucky = lucky;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (id != answer.id) return false;
        if (content != null ? !content.equals(answer.content) : answer.content != null) return false;
        if (authorId != null ? !authorId.equals(answer.authorId) : answer.authorId != null) return false;
        if (questionId != null ? !questionId.equals(answer.questionId) : answer.questionId != null) return false;
        if (createdAt != null ? !createdAt.equals(answer.createdAt) : answer.createdAt != null) return false;
        if (lastUpdatedAt != null ? !lastUpdatedAt.equals(answer.lastUpdatedAt) : answer.lastUpdatedAt != null)
            return false;
        if (voteCount != null ? !voteCount.equals(answer.voteCount) : answer.voteCount != null) return false;
        if (lucky != null ? !lucky.equals(answer.lucky) : answer.lucky != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lastUpdatedAt != null ? lastUpdatedAt.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        result = 31 * result + (lucky != null ? lucky.hashCode() : 0);
        return result;
    }
}
