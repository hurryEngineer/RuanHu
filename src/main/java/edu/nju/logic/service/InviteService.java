package edu.nju.logic.service;

import java.util.List;

/**
 * Created by cuihao on 2016/7/21.
 */
public interface InviteService {
    void inivite(long questionId, long userId, List<Long> inviteIds);
}
