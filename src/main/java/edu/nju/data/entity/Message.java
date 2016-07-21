package edu.nju.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ss14 on 2016/7/21.
 */
@Entity
public class Message {
    private Long id;
    private Serializable mesgType;
    private Long sourceId;
    private String content;
    private Timestamp createdAt =new Timestamp( new Date().getTime());
    private Short checked = 0;
    private User receiver;
    private User sender;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mesg_type")
    public Serializable getMesgType() {
        return mesgType;
    }

    public void setMesgType(Serializable mesgType) {
        this.mesgType = mesgType;
    }

    @Basic
    @Column(name = "source_id")
    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "checked")
    public Short getChecked() {
        return checked;
    }

    public void setChecked(Short checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (sourceId != message.sourceId) return false;
        if (mesgType != null ? !mesgType.equals(message.mesgType) : message.mesgType != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (createdAt != null ? !createdAt.equals(message.createdAt) : message.createdAt != null) return false;
        if (checked != null ? !checked.equals(message.checked) : message.checked != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (mesgType != null ? mesgType.hashCode() : 0);
        result = 31 * result + (int) (sourceId ^ (sourceId >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (checked != null ? checked.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @OneToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
