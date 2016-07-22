package edu.nju.logic.vo;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.Question;

/**
 * Created by cuihao on 2016/7/21.
 */

public class MessageVO extends Message{
    Answer answer = null;
    Question question = null;

    public MessageVO(Message message) {
        this.setId(message.getId());
        this.setMesgType(message.getMesgType());
        this.setSourceId(message.getSourceId());
        this.setCreatedAt(message.getCreatedAt());
        this.setChecked(message.getChecked());
        this.setSender(message.getSender());
        this.setReceiver(message.getReceiver());
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
