package edu.nju.data.util;

/**
 * Created by Dora on 2016/7/26.
 */
public class KeyMatch {
    String content;

    String type = "markdown";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "KeyMatch{" +
                "content='" + content + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
