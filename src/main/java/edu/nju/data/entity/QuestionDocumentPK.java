package edu.nju.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/20.
 */
public class QuestionDocumentPK implements Serializable {
    private long questionId;
    private long documentId;

    @Column(name = "question_id")
    @Id
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
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

        QuestionDocumentPK that = (QuestionDocumentPK) o;

        if (questionId != that.questionId) return false;
        if (documentId != that.documentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (questionId ^ (questionId >>> 32));
        result = 31 * result + (int) (documentId ^ (documentId >>> 32));
        return result;
    }
}
