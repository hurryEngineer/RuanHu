package edu.nju.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/11.
 */
public class AnswerVotesPK implements Serializable {
    private long answerId;
    private long votesId;

    @Column(name = "Answer_id")
    @Id
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    @Column(name = "votes_id")
    @Id
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

        AnswerVotesPK that = (AnswerVotesPK) o;

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
