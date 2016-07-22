package edu.nju.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ss14 on 2016/7/22.
 */
public class TestPK implements Serializable {
    private long aid;
    private long bid;

    @Column(name = "aid")
    @Id
    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    @Column(name = "bid")
    @Id
    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestPK testPK = (TestPK) o;

        if (aid != testPK.aid) return false;
        if (bid != testPK.bid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (aid ^ (aid >>> 32));
        result = 31 * result + (int) (bid ^ (bid >>> 32));
        return result;
    }
}
