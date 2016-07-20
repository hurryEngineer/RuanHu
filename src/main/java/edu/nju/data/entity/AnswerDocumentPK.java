package edu.nju.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/20.
 */
public class AnswerDocumentPK implements Serializable {
    private long answerId;
    private long documentId;

    @Column(name = "answer_id")
    @Id
    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    @Column(name = "document_id")
    @Id
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

        AnswerDocumentPK that = (AnswerDocumentPK) o;

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
