package edu.nju.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/11.
 */
public class QuestionVotesPK implements Serializable {
    private long questionId;
    private long votesId;

    @Column(name = "question_id")
    @Id
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
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

        QuestionVotesPK that = (QuestionVotesPK) o;

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
