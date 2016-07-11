package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "answer_votes", schema = "RuanHu", catalog = "")
public class AnswerVotesEntity {
    private VoteEntity voteByVotesId;
    private AnswerEntity answerByAnswerId;

    @ManyToOne
    @JoinColumn(name = "votes_id", referencedColumnName = "id", nullable = false)
    public VoteEntity getVoteByVotesId() {
        return voteByVotesId;
    }

    public void setVoteByVotesId(VoteEntity voteByVotesId) {
        this.voteByVotesId = voteByVotesId;
    }

    @ManyToOne
    @JoinColumn(name = "Answer_id", referencedColumnName = "id", nullable = false)
    public AnswerEntity getAnswerByAnswerId() {
        return answerByAnswerId;
    }

    public void setAnswerByAnswerId(AnswerEntity answerByAnswerId) {
        this.answerByAnswerId = answerByAnswerId;
    }
}
