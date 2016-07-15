package edu.nju.data.dao;

import edu.nju.data.entity.Vote;

/**
 * Created by ss14 on 2016/7/12.
 */
public interface VoteDAO {
    /**
     * 保存新的Vote
     * @param vote
     */
    void save(Vote vote);

    /**
     * 点赞操作，可以自动识别是第一次Vote，还是改变方向的Vote
     * @param vote
     */
    void vote(Vote vote);

    /**
     * 取消赞
     * @param vote  原来的Vote
     */
    void cancel(Vote vote);


}
