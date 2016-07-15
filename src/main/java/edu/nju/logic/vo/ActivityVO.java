package edu.nju.logic.vo;

import java.sql.Timestamp;

/**
 * 展示用户动态
 */
public class ActivityVO implements Comparable<ActivityVO>{
    private ActivityType type;
    private String title;
    private String content;
    private Timestamp update;
    private String updateAtForView;
    private Object activity;

    public Object getActivity() {
        return activity;
    }

    public void setActivity(Object activity) {
        this.activity = activity;
    }

    public ActivityVO(QuestionVO questionVO) {
        setTitle(questionVO.getTitle());
        setContent(questionVO.getContent());
        setUpdate(questionVO.getLastUpdatedAt());
        setUpdateAtForView(questionVO.getUpdateAtForView());
        setType(ActivityType.QUESTION);
        setActivity(questionVO);
    }

    public ActivityVO(AnswerVO answerVO) {
        setTitle(answerVO.getQuestion().getTitle());
        setContent(answerVO.getContent());
        setUpdate(answerVO.getLastUpdatedAt());
        setUpdateAtForView(answerVO.getUpdateAtForView());
        setType(ActivityType.ANSWER);
        setActivity(answerVO);
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getUpdate() {
        return update;
    }

    public void setUpdate(Timestamp update) {
        this.update = update;
    }

    public String getUpdateAtForView() {
        return updateAtForView;
    }

    public void setUpdateAtForView(String updateAtForView) {
        this.updateAtForView = updateAtForView;
    }

    @Override
    public int compareTo(ActivityVO activityVO) {
        return update.compareTo(activityVO.getUpdate());
    }

    @Override
    public String toString() {
        return "ActivityVO{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", update=" + update +
                ", updateAtForView='" + updateAtForView + '\'' +
                ", activity=" + activity +
                '}';
    }
}
