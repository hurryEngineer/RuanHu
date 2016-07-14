package edu.nju.data.dao;

import edu.nju.data.entity.Vote;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface VoteDAO {
    /**
     * 点赞
     * @param vote
     */
    void save(Vote vote);

    /**
     * 取消赞
     * @param vote
     */
    void cancel(Vote vote);


}
