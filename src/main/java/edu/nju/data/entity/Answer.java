package edu.nju.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ss14 on 2016/7/13.
 */
@Entity
public class Answer implements date_interface{
    private long id;
    private String content;
    private long questionId;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private Integer voteCount;
    private Byte solution;
    private User author;
    private List<Comment> commentList;

    @Transient
    public void setAuthorId(long id){
        this.getAuthor().setId(id);
    }
    @Transient
    public long getAuthorId(){
        return this.getAuthor().getId();
    }


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
    @Column(name = "question_id")
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
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
    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @Basic
    @Column(name = "solution")
    public Byte getSolution() {
        return solution;
    }

    public void setSolution(Byte solution) {
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (id != answer.id) return false;
        if (questionId != answer.questionId) return false;
        if (content != null ? !content.equals(answer.content) : answer.content != null) return false;
        if (createdAt != null ? !createdAt.equals(answer.createdAt) : answer.createdAt != null) return false;
        if (lastUpdatedAt != null ? !lastUpdatedAt.equals(answer.lastUpdatedAt) : answer.lastUpdatedAt != null)
            return false;
        if (voteCount != null ? !voteCount.equals(answer.voteCount) : answer.voteCount != null) return false;
        if (solution != null ? !solution.equals(answer.solution) : answer.solution != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) (questionId ^ (questionId >>> 32));
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lastUpdatedAt != null ? lastUpdatedAt.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
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

    @OneToMany(mappedBy = "answerId")
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
