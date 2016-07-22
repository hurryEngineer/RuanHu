package edu.nju.web.controller.json;

import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.service.UserProfileService;
import edu.nju.logic.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/7/12.
 */
@Controller
//@RequestMapping("/userProfile")
@SessionAttributes("user")
@RequestMapping("/json")
public class UserProfileJsonController {

    @Autowired
    private UserProfileService profileService;

    @Autowired
    private TransferService transferService;


    /**
     * 搜索用户（邀请回答时用）
     * @param nameKey 用户名关键字
     * @return 符合关键词的用户信息
     */
    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    @ResponseBody
    List<UserVO> getUserByNameKey(@RequestParam("key")String nameKey) {
        List<UserVO> userVOs = new ArrayList<>();
        List<User> users = profileService.getSearchUser(nameKey);
        if (users!=null) {
            for (User user: users) {
                userVOs.add(transferService.transferUser(user));
            }
        }
        return userVOs;
    }

    /**
     * 获取用户的消息
     * @param userId 用户id
     * @return 用户所有的消息
     */
    @RequestMapping(value = "/user/message", method = RequestMethod.GET)
    @ResponseBody
    List<Message> getUserMessage(@RequestParam("userId") long userId) {
        return profileService.getUserMessage(userId);
    }

    @RequestMapping(value = "/user/messageCount", method = RequestMethod.GET)
    @ResponseBody
    long getUserMessageCount(@RequestParam("userId")String userId) {
        return profileService.getMessageCount(Long.valueOf(userId));
    }

    @RequestMapping(value = "/editBirthday", method = RequestMethod.POST)
    @ResponseBody
    void editBirthday(String birthday, HttpSession session){
        Object user = session.getAttribute("user");
        if (user!=null) {
            profileService.editBirthday((User) user, birthday);
        }
    }

    @RequestMapping(value = "/editDescription", method = RequestMethod.POST)
    @ResponseBody
    void editDescription(String description,
                           HttpSession session){
        Object user = session.getAttribute("user");
        if (user!=null) {
            profileService.editDescription((User) user, description);;
        }
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    @ResponseBody
    void editLocation(String location, HttpSession session){
        Object user = session.getAttribute("user");
        if (user!=null) {
            profileService.editLocation((User) user, location);
        }
    }

//    @RequestMapping(value = "/editDescription")
//    String editDescription(@RequestParam("description") String description,
//                           HttpSession session){
//        Object user = session.getAttribute("user");
//        if (user!=null)
//            profileService.editDescription((User)user, description);
//        return "redirect:/userProfile/"+((User)user).getUserName();
//    }
}
