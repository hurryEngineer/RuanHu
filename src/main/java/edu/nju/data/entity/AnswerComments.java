package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/12.
 */
@Entity
@Table(name = "answer_comments", schema = "RuanHu", catalog = "")
@IdClass(AnswerCommentsPK.class)
public class AnswerComments {
    private long answerId;
    private long commentsId;

    @Id
    @Column(name = "answer_id")
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    @Id
    @Column(name = "comments_id")
    public long getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(long commentsId) {
        this.commentsId = commentsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerComments that = (AnswerComments) o;

        if (answerId != that.answerId) return false;
        if (commentsId != that.commentsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (answerId ^ (answerId >>> 32));
        result = 31 * result + (int) (commentsId ^ (commentsId >>> 32));
        return result;
    }
}
