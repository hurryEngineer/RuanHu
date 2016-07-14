package edu.nju.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by ss14 on 2016/7/13.
 */
@Entity
public class Answer implements DateInterface{
    private Long id;
    private String content;
    private long questionId;
    private Timestamp createdAt = new Timestamp( new Date().getTime());
    private Timestamp lastUpdatedAt;
    private Integer voteCount= new Integer(0);
    private Byte solution;
    private User author = new User();
    private List<Comment> commentList;

    @Transient
    public void setAuthorId(Long id){
        this.getAuthor().setId(id);
    }
    @Transient
    public Long getAuthorId(){
        return this.getAuthor().getId();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
