package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "question_comments", schema = "RuanHu", catalog = "")
public class QuestionCommentsEntity {
    private CommentEntity commentByCommentsId;
    private QuestionEntity questionByQuestionId;

    @ManyToOne
    @JoinColumn(name = "comments_id", referencedColumnName = "id", nullable = false)
    public CommentEntity getCommentByCommentsId() {
        return commentByCommentsId;
    }

    public void setCommentByCommentsId(CommentEntity commentByCommentsId) {
        this.commentByCommentsId = commentByCommentsId;
    }

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }
}
