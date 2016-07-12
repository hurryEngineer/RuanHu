package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "question_votes", schema = "RuanHu", catalog = "")
@IdClass(QuestionVotesPK.class)
public class QuestionVotes {
    private long questionId;
    private long votesId;

    @Id
    @Column(name = "question_id")
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    @Id
    @Column(name = "votes_id")
    public long getVotesId() {
        return votesId;
    }

    public void setVotesId(long votesId) {
        this.votesId = votesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionVotes that = (QuestionVotes) o;

        if (questionId != that.questionId) return false;
        if (votesId != that.votesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (questionId ^ (questionId >>> 32));
        result = 31 * result + (int) (votesId ^ (votesId >>> 32));
        return result;
    }
}
