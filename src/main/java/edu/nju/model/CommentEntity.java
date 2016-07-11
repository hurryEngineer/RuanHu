package edu.nju.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "comment", schema = "RuanHu", catalog = "")
public class CommentEntity {
    private Collection<AnswerCommentsEntity> answerCommentsesById;
    private UsersEntity usersByAuthorId;
    private Collection<QuestionCommentsEntity> questionCommentsesById;

    @OneToMany(mappedBy = "commentByCommentsId")
    public Collection<AnswerCommentsEntity> getAnswerCommentsesById() {
        return answerCommentsesById;
    }

    public void setAnswerCommentsesById(Collection<AnswerCommentsEntity> answerCommentsesById) {
        this.answerCommentsesById = answerCommentsesById;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(UsersEntity usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }

    @OneToMany(mappedBy = "commentByCommentsId")
    public Collection<QuestionCommentsEntity> getQuestionCommentsesById() {
        return questionCommentsesById;
    }

    public void setQuestionCommentsesById(Collection<QuestionCommentsEntity> questionCommentsesById) {
        this.questionCommentsesById = questionCommentsesById;
    }
}
