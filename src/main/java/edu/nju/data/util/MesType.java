package edu.nju.data.util;

/**
 * Created by ss14 on 2016/7/21.
 */
public enum MesType {
    /**
     *  当用户为其他用户点赞时，通知被点赞的用户
     */
    voteAnswer,
    /**
     *  当用户为其他用户点赞时，通知被点赞的用户
     */
    voteQuestion,
    /**
     *  当用户评论其他用户时，通知被评论的用户
     */
    comment,
    /**
     *  当用户回答其他用户时，通知被回答的用户
     */
    answer,
    /**
     *  当用户邀请其他用户回答时，通知被邀请的用户
     */
    invite
}
