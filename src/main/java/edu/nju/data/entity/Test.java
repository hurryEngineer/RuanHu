package edu.nju.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by ss14 on 2016/7/22.
 */
@Entity
@IdClass(TestPK.class)
public class Test {
    private long aid;
    private long bid;

    @Id
    @Column(name = "aid")
    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    @Id
    @Column(name = "bid")
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

        Test test = (Test) o;

        if (aid != test.aid) return false;
        if (bid != test.bid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (aid ^ (aid >>> 32));
        result = 31 * result + (int) (bid ^ (bid >>> 32));
        return result;
    }
}
