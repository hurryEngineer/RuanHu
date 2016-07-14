package edu.nju.data.entity;

import edu.nju.data.util.VoteType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ss14 on 2016/7/13.
 */
@Entity
public class Vote {
    private long id;
    private long authorId;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private Long answerId;
    private Long questionId;
    private VoteType voteType;

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
    @Column(name = "author_id")
    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
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


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (authorId != vote.authorId) return false;
        if (createdAt != null ? !createdAt.equals(vote.createdAt) : vote.createdAt != null) return false;
        if (lastUpdatedAt != null ? !lastUpdatedAt.equals(vote.lastUpdatedAt) : vote.lastUpdatedAt != null)
            return false;
        if (answerId != null ? !answerId.equals(vote.answerId) : vote.answerId != null) return false;
        if (questionId != null ? !questionId.equals(vote.questionId) : vote.questionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (authorId ^ (authorId >>> 32));
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lastUpdatedAt != null ? lastUpdatedAt.hashCode() : 0);
        result = 31 * result + (answerId != null ? answerId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        return result;
    }


}
