package edu.nju.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/20.
 */
public class QuestionWikiPK implements Serializable {
    private long questionId;
    private long wikiId;

    @Column(name = "question_id")
    @Id
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    @Column(name = "wiki_id")
    @Id
    public long getWikiId() {
        return wikiId;
    }

    public void setWikiId(long wikiId) {
        this.wikiId = wikiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionWikiPK that = (QuestionWikiPK) o;

        if (questionId != that.questionId) return false;
        if (wikiId != that.wikiId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (questionId ^ (questionId >>> 32));
        result = 31 * result + (int) (wikiId ^ (wikiId >>> 32));
        return result;
    }
}
