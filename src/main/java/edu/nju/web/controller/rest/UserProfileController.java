package edu.nju.web.controller.rest;

import edu.nju.data.entity.User;
import edu.nju.logic.service.UserProfileService;
import edu.nju.logic.vo.ActivityVO;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cuihao on 2016/7/12.
 */
@Controller
//@RequestMapping("/userProfile")
@SessionAttributes("user")
@RequestMapping("/rest")
public class UserProfileController {
    @Autowired
    private UserProfileService profileService;

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

    @RequestMapping(value = "/userProfile/showAnswers")
    String showAnswers(@RequestParam("userName") String userName, Model model, HttpSession session) {
        Object user = session.getAttribute("user");
        model.addAttribute("userName",userName);
        System.out.println(profileService.getAnswerByName(userName,user==null?-1:((User)user).getId()));
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
