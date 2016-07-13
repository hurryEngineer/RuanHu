package edu.nju.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ss14 on 2016/7/13.
 */
@Entity
public class AlibabaKey {
    private String accessKeySecret;
    private String accessKeyId;

    @Basic
    @Column(name = "AccessKeySecret")
    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    @Id
    @Column(name = "AccessKeyId")
    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlibabaKey that = (AlibabaKey) o;

        if (accessKeySecret != null ? !accessKeySecret.equals(that.accessKeySecret) : that.accessKeySecret != null)
            return false;
        if (accessKeyId != null ? !accessKeyId.equals(that.accessKeyId) : that.accessKeyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accessKeySecret != null ? accessKeySecret.hashCode() : 0;
        result = 31 * result + (accessKeyId != null ? accessKeyId.hashCode() : 0);
        return result;
    }
}
