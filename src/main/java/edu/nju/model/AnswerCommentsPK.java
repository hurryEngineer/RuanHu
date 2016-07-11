package edu.nju.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/11.
 */
public class AnswerCommentsPK implements Serializable {
    private long answerId;
    private long commentsId;

    @Column(name = "Answer_id")
    @Id
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    @Column(name = "comments_id")
    @Id
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

        AnswerCommentsPK that = (AnswerCommentsPK) o;

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
