package edu.nju.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "answer", schema = "RuanHu", catalog = "")
public class AnswerEntity {
    private QuestionEntity questionByQuestionId;
    private UsersEntity usersByAuthorId;
    private Collection<AnswerCommentsEntity> answerCommentsesById;
    private Collection<AnswerVotesEntity> answerVotesById;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public UsersEntity getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(UsersEntity usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }

    @OneToMany(mappedBy = "answerByAnswerId")
    public Collection<AnswerCommentsEntity> getAnswerCommentsesById() {
        return answerCommentsesById;
    }

    public void setAnswerCommentsesById(Collection<AnswerCommentsEntity> answerCommentsesById) {
        this.answerCommentsesById = answerCommentsesById;
    }

    @OneToMany(mappedBy = "answerByAnswerId")
    public Collection<AnswerVotesEntity> getAnswerVotesById() {
        return answerVotesById;
    }

    public void setAnswerVotesById(Collection<AnswerVotesEntity> answerVotesById) {
        this.answerVotesById = answerVotesById;
    }
}
