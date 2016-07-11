package edu.nju.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/11.
 */
public class QuestionCommentsPK implements Serializable {
    private long questionId;
    private long commentsId;

    @Column(name = "question_id")
    @Id
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
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

        QuestionCommentsPK that = (QuestionCommentsPK) o;

        if (questionId != that.questionId) return false;
        if (commentsId != that.commentsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (questionId ^ (questionId >>> 32));
        result = 31 * result + (int) (commentsId ^ (commentsId >>> 32));
        return result;
    }
}
