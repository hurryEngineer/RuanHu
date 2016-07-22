package edu.nju.web.controller;

import edu.nju.data.entity.User;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cuihao on 2016/7/12.
 */
@Controller
//@RequestMapping("/userProfile")
@SessionAttributes("user")
public class UserProfileController {
    @Autowired
    private UserProfileService profileService;

    @Autowired
    private TransferService transferService;

    /**
     * 显示用户信息
     * @param session {@link HttpSession}
     * @return 用户信息类 {@link User}
     */
    @RequestMapping(value = "/userProfile/{userName}",method = RequestMethod.GET)
    String showProfile(@PathVariable("userName") String userName, HttpSession session, Model model){
        Object me = null;
        model.addAttribute("isMe", (me = session.getAttribute("user"))!=null && ((User)me).getUserName().equals(userName));
        model.addAttribute("userInfo", profileService.getUserByName(userName));
        model.addAttribute("questionCount",profileService.getQuestionCountByName(userName));
        model.addAttribute("answerCount",profileService.getAnswerCountByName(userName));
        return "user/userProfile";
    }


    @RequestMapping(value = "/userProfile/showQuestion")
    String showUserQuestion(@RequestParam("userName") String userName,Model model, HttpSession session) {
        Object user = session.getAttribute("user");
        model.addAttribute("userName",userName);
        model.addAttribute("activities",profileService.getQuestionByName(userName,user==null?-1:((User)user).getId()));
        return "user/user_questionList";
    }

    @RequestMapping(value = "/userProfile/message")
    String showUserMessage(@RequestParam("userId") String userId, Model model, HttpSession session) {
        model.addAttribute("message",transferService.transferMessage(profileService.getUserMessage(Long.valueOf(userId))));
        return "user/user_notificationList";
    }

    @RequestMapping(value = "/userProfile/readMessage", method = RequestMethod.POST)
    String readMessage(@RequestParam("messageIds")List<Long> messageIds) {
        profileService.readMessage(messageIds);
        return "user/userProfile";
    }

    @RequestMapping(value = "/userProfile/showAnswers")
    String showAnswers(@RequestParam("userName") String userName, Model model, HttpSession session) {
        Object user = session.getAttribute("user");
        model.addAttribute("userName",userName);
//        System.out.println(profileService.getAnswerByName(userName,user==null?-1:((User)user).getId()));
        model.addAttribute("activities",profileService.getAnswerByName(userName,user==null?-1:((User)user).getId()));
        return "user/user_answerList";
    }

    /**
     * 编辑用户信
     * @param birthday 编辑后的用户生日
     * @param session {@link HttpSession}
     */
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public void editProfile(@RequestParam("description") String description,
//                            @RequestParam("location") String location,
//                            @RequestParam("birthday") String birthday, HttpSession session){
//        Object user = session.getAttribute("user");
//        if (user!=null)
//            profileService.editProfile((User)user, description, location, birthday);
//    }


//    @RequestMapping(value = "/editDescription")
//    String editDescription(@RequestParam("description") String description,
//                           HttpSession session){
//        Object user = session.getAttribute("user");
//        if (user!=null)
//            profileService.editDescription((User)user, description);
//        return "redirect:/userProfile/"+((User)user).getUserName();
//    }
}
