package edu.nju.data.entity.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dora on 2016/7/20.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class WikiItem {

    private long id;

    private String title;

//    @JsonProperty("summary")
    private String summary;

    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String content) {
        this.summary = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WikiItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + summary + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
