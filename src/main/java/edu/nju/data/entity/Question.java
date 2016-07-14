package edu.nju.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ss14 on 2016/7/13.
 */
@Entity
public class Question {
    private long id;
    private Integer answerCount;
    private Integer voteCount;
    private Integer viewCount;
    private String title;
    private String content;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
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
    @Column(name = "answer_count")
    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
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
    @Column(name = "view_count")
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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
        if (answerCount != null ? !answerCount.equals(question.answerCount) : question.answerCount != null)
            return false;
        if (voteCount != null ? !voteCount.equals(question.voteCount) : question.voteCount != null) return false;
        if (viewCount != null ? !viewCount.equals(question.viewCount) : question.viewCount != null) return false;
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
        result = 31 * result + (answerCount != null ? answerCount.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lastUpdatedAt != null ? lastUpdatedAt.hashCode() : 0);
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

    @OneToMany(mappedBy = "questionId")
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
