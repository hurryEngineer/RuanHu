package edu.nju.data.dao;

import edu.nju.data.entity.Vote;
import edu.nju.data.util.VoteType;

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

    /**
     * 之前是否投过同类型的票
     * @param userId 用户id
     * @param questionId 问题id
     * @param type 要验证的投票类型
     * @return 之前投过同类型的票则返回 {@code true}， 否则返回 {@code false}
     */
    boolean hasVoteQuestion(long userId, long questionId, VoteType type);

    /**
     * 之前是否投过同类型的票
     * @param userId 用户id
     * @param answerId 回答id
     * @param type 要验证的投票类型
     * @return 之前投过同类型的票则返回 {@code true}， 否则返回 {@code false}
     */
    boolean hasVoteAnswer(long userId, long answerId, VoteType type);


}
