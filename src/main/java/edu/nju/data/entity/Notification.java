package edu.nju.data.entity;

import edu.nju.data.util.Source;

/**
 * Created by Dora on 2016/7/20.
 */
public class Notification {

    private String message;

    private CommonUser user;

    private Source source;


    public Notification() {
    }

    public Notification(String message, CommonUser user, Source source) {
        this.message = message;
        this.user = user;
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommonUser getUser() {
        return user;
    }

    public void setUser(CommonUser user) {
        this.user = user;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                ", user=" + user +
                ", source=" + source +
                '}';
    }
}
