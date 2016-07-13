package edu.nju.logic.service;

import edu.nju.data.entity.User;

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
}
