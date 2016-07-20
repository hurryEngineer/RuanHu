package edu.nju.data.entity;

import javax.persistence.*;

/**
 * Created by ss14 on 2016/7/20.
 */
@Entity
@Table(name = "answer_document", schema = "RuanHu", catalog = "")
@IdClass(AnswerDocumentPK.class)
public class AnswerDocument {
    private long answerId;
    private long documentId;

    @Id
    @Column(name = "answer_id")
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    @Id
    @Column(name = "document_id")
    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerDocument that = (AnswerDocument) o;

        if (answerId != that.answerId) return false;
        if (documentId != that.documentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (answerId ^ (answerId >>> 32));
        result = 31 * result + (int) (documentId ^ (documentId >>> 32));
        return result;
    }
}
