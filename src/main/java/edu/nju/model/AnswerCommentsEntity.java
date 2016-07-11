package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "answer_comments", schema = "RuanHu", catalog = "")
public class AnswerCommentsEntity {
    private AnswerEntity answerByAnswerId;
    private CommentEntity commentByCommentsId;

    @ManyToOne
    @JoinColumn(name = "Answer_id", referencedColumnName = "id", nullable = false)
    public AnswerEntity getAnswerByAnswerId() {
        return answerByAnswerId;
    }

    public void setAnswerByAnswerId(AnswerEntity answerByAnswerId) {
        this.answerByAnswerId = answerByAnswerId;
    }

    @ManyToOne
    @JoinColumn(name = "comments_id", referencedColumnName = "id", nullable = false)
    public CommentEntity getCommentByCommentsId() {
        return commentByCommentsId;
    }

    public void setCommentByCommentsId(CommentEntity commentByCommentsId) {
        this.commentByCommentsId = commentByCommentsId;
    }
}
