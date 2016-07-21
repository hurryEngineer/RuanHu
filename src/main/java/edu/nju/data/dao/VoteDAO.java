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
     * @return   返回现在应有的voteCount
     */
    int  vote(Vote vote);


    /**
     * 之前是否投过同类型的票
     * @param userId 用户id
     * @param questionId 问题id
     * @return 之前投过同类型的票则返回 {@code true}， 否则返回 {@code false}
     */
    int hasVoteQuestion(long userId, long questionId);

    /**
     * 之前是否投过同类型的票
     * @param userId 用户id
     * @param answerId 回答id
     * @return 之前投过同类型的票则返回 {@code true}， 否则返回 {@code false}
     */
    int hasVoteAnswer(long userId, long answerId);


}
