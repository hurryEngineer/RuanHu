package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "question_comments", schema = "RuanHu", catalog = "")
@IdClass(QuestionCommentsPK.class)
public class QuestionComments {
    private long questionId;
    private long commentsId;

    @Id
    @Column(name = "question_id")
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
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

        QuestionComments that = (QuestionComments) o;

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
