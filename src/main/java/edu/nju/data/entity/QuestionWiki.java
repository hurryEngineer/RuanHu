package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/20.
 */
@Entity
@Table(name = "question_wiki", schema = "RuanHu", catalog = "")
@IdClass(QuestionWikiPK.class)
public class QuestionWiki {
    private long questionId;
    private long wikiId;

    @Id
    @Column(name = "question_id")
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
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

        QuestionWiki that = (QuestionWiki) o;

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
