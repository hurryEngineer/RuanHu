package edu.nju.logic.service;

import edu.nju.data.entity.User;
import edu.nju.data.util.VoteType;

/**
 * 回答接口
 * @author cuihao
 */
public interface AnswerService {
    /**
     * 将问题标注为满意回答
     * @param user 当前登陆用户
     * @param questionId 问题ID
     * @param answerId 回答ID
     * @return 是否有权限标注
     */
    boolean markAsSolution(User user, long questionId, long answerId);

    /**
     * 保存回答
     * @param questionId 回答的问题ID
     * @param userId 回答该问题的用户id
     * @param text 回答的内容
     * @return 是否保存成功
     */
    boolean saveAnswer(long questionId, long userId, String text);

    boolean editAnswer(long answerId, String text);

    /**
     * 点赞
     * @param questionId 问题id
     * @param answerId 答案id
     * @param userId 用户id
     * @param type 顶还是踩
     */
    void vote(String questionId, String answerId, String userId, VoteType type);

    /**
     * 取消赞
     * @param questionId 问题id
     * @param answerId 答案id
     * @param userId 用户id
     * @param type 之前的赞是定还是踩
     */
    void unVote(String questionId, String answerId, String userId, VoteType type);
}
