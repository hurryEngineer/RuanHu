package edu.nju.logic.service;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.vo.ActivityVO;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;

import java.util.List;

/**
 * 用户个人信息接口
 * @author cuihao
 */
public interface UserProfileService {
    /**
     * 更新用户的个人信息
     * @param user 登陆后保存在session里的用户类
     * @param description 用户更新后的个人描述
     * @param location 用户更新后的地址
     * @param bitrhday 用户更新后的生日
     * @return 是否更新成功
     */
    boolean editProfile(User user, String description, String location, String bitrhday);

    boolean editBirthday(User user, String bitrhday);

    boolean editDescription(User user, String description);

    boolean editLocation(User user, String location);

    User getUserByName(String name);

    long getQuestionCountByName(String name);

    long getAnswerCountByName(String name);

    List<QuestionVO> getQuestionByName(String name, long userId);

    List<AnswerVO> getAnswerByName(String name, long userId);

    List<ActivityVO> orderedActivity(List<QuestionVO> questionVOs, List<AnswerVO> answerVOs);

    List<Message> getUserMessage(long userId);

    List<User> getSearchUser(String keyword);

    long getMessageCount(long userId);

    void readMessage(List<Long> messageIds);

}
