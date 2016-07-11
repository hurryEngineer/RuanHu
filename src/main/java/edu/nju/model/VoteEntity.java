package edu.nju.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "vote", schema = "RuanHu", catalog = "")
public class VoteEntity {
    private Collection<AnswerVotesEntity> answerVotesById;
    private Collection<QuestionVotesEntity> questionVotesById;
    private UsersEntity usersByAuthorId;

    @OneToMany(mappedBy = "voteByVotesId")
    public Collection<AnswerVotesEntity> getAnswerVotesById() {
        return answerVotesById;
    }

    public void setAnswerVotesById(Collection<AnswerVotesEntity> answerVotesById) {
        this.answerVotesById = answerVotesById;
    }

    @OneToMany(mappedBy = "voteByVotesId")
    public Collection<QuestionVotesEntity> getQuestionVotesById() {
        return questionVotesById;
    }

    public void setQuestionVotesById(Collection<QuestionVotesEntity> questionVotesById) {
        this.questionVotesById = questionVotesById;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public UsersEntity getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(UsersEntity usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }
}
