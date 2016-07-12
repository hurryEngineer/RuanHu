package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "answer_votes", schema = "RuanHu", catalog = "")
@IdClass(AnswerVotesPK.class)
public class AnswerVotes {
    private long answerId;
    private long votesId;

    @Id
    @Column(name = "answer_id")
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
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

        AnswerVotes that = (AnswerVotes) o;

        if (answerId != that.answerId) return false;
        if (votesId != that.votesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (answerId ^ (answerId >>> 32));
        result = 31 * result + (int) (votesId ^ (votesId >>> 32));
        return result;
    }
}
