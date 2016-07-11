package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "users", schema = "RuanHu", catalog = "")
public class UsersEntity {
    private Collection<AnswerEntity> answersById;
    private Collection<CommentEntity> commentsById;
    private Collection<VoteEntity> votesById;

    @OneToMany(mappedBy = "usersByAuthorId")
    public Collection<AnswerEntity> getAnswersById() {
        return answersById;
    }

    public void setAnswersById(Collection<AnswerEntity> answersById) {
        this.answersById = answersById;
    }

    @OneToMany(mappedBy = "usersByAuthorId")
    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "usersByAuthorId")
    public Collection<VoteEntity> getVotesById() {
        return votesById;
    }

    public void setVotesById(Collection<VoteEntity> votesById) {
        this.votesById = votesById;
    }
}
