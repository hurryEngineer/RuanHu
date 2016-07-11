package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by ss14 on 2016/7/11.
 */
@Entity
@Table(name = "question", schema = "RuanHu", catalog = "")
public class QuestionEntity {
    private Collection<AnswerEntity> answersById;
    private Collection<QuestionCommentsEntity> questionCommentsesById;
    private Collection<QuestionVotesEntity> questionVotesById;

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<AnswerEntity> getAnswersById() {
        return answersById;
    }

    public void setAnswersById(Collection<AnswerEntity> answersById) {
        this.answersById = answersById;
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<QuestionCommentsEntity> getQuestionCommentsesById() {
        return questionCommentsesById;
    }

    public void setQuestionCommentsesById(Collection<QuestionCommentsEntity> questionCommentsesById) {
        this.questionCommentsesById = questionCommentsesById;
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<QuestionVotesEntity> getQuestionVotesById() {
        return questionVotesById;
    }

    public void setQuestionVotesById(Collection<QuestionVotesEntity> questionVotesById) {
        this.questionVotesById = questionVotesById;
    }
}
