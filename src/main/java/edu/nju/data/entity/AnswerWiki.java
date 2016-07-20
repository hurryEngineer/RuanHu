package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/20.
 */
@Entity
@Table(name = "answer_wiki", schema = "RuanHu", catalog = "")
@IdClass(AnswerWikiPK.class)
public class AnswerWiki {
    private long answerId;
    private long wikiId;

    @Id
    @Column(name = "answer_id")
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    @Id
    @Column(name = "wiki_id")
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

        AnswerWiki that = (AnswerWiki) o;

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
