package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/20.
 */
@Entity
@Table(name = "question_wiki", schema = "RuanHu", catalog = "")
public class QuestionWiki {
    private long questionId;
    private long wikiId;
    private Long id;

    @Basic
    @Column(name = "question_id")
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "wiki_id")
    public long getWikiId() {
        return wikiId;
    }

    public void setWikiId(long wikiId) {
        this.wikiId = wikiId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionWiki that = (QuestionWiki) o;

        if (questionId != that.questionId) return false;
        if (wikiId != that.wikiId) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (questionId ^ (questionId >>> 32));
        result = 31 * result + (int) (wikiId ^ (wikiId >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
