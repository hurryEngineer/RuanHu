package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "question_votes", schema = "RuanHu", catalog = "")
public class QuestionVotesEntity {
    private QuestionEntity questionByQuestionId;
    private VoteEntity voteByVotesId;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }

    @ManyToOne
    @JoinColumn(name = "votes_id", referencedColumnName = "id", nullable = false)
    public VoteEntity getVoteByVotesId() {
        return voteByVotesId;
    }

    public void setVoteByVotesId(VoteEntity voteByVotesId) {
        this.voteByVotesId = voteByVotesId;
    }
}
