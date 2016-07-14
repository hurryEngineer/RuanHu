package edu.nju.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ss14 on 2016/7/13.
 */
@Entity
public class Comment {
    private long id;
    private String content;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private Long answerId;
    private Long questionId;
    private User author;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "answer_id")
    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "question_id")
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (createdAt != null ? !createdAt.equals(comment.createdAt) : comment.createdAt != null) return false;
        if (lastUpdatedAt != null ? !lastUpdatedAt.equals(comment.lastUpdatedAt) : comment.lastUpdatedAt != null)
            return false;
        if (answerId != null ? !answerId.equals(comment.answerId) : comment.answerId != null) return false;
        if (questionId != null ? !questionId.equals(comment.questionId) : comment.questionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lastUpdatedAt != null ? lastUpdatedAt.hashCode() : 0);
        result = 31 * result + (answerId != null ? answerId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
