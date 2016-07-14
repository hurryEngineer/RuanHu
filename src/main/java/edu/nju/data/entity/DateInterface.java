package edu.nju.data.entity;

import java.sql.Timestamp;

/**
 * Created by ss14 on 2016/7/14.
 */
public interface DateInterface {

     Timestamp getCreatedAt();

     Timestamp getLastUpdatedAt();
}
