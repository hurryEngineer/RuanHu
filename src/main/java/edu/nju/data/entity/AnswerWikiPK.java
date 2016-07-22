package edu.nju.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/22.
 */
public class AnswerWikiPK implements Serializable {
    private long answerId;
    private long wikiId;

    @Column(name = "answer_id")
    @Id
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
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

        AnswerWikiPK that = (AnswerWikiPK) o;

        if (answerId != that.answerId) return false;
        if (wikiId != that.wikiId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (answerId ^ (answerId >>> 32));
        result = 31 * result + (int) (wikiId ^ (wikiId >>> 32));
        return result;
    }
}
