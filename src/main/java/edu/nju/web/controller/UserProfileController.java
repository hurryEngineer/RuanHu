package edu.nju.web.controller;

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
@RequestMapping("/userProfile")
@SessionAttributes("user")
public class UserProfileController {
    @Autowired
    private UserProfileService profileService;

    /**
     * 显示用户信息
     * @param session {@link HttpSession}
     * @return 用户信息类 {@link User}
     */
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    String showProfile(@RequestParam("userName") String userName, HttpSession session, Model model){
        Object me = null;
        model.addAttribute("isMe", (me = session.getAttribute("user"))!=null && ((User)me).getUserName().equals(userName));
        model.addAttribute("userInfo", profileService.getUserByName(userName));
        model.addAttribute("questionCount",profileService.getQuestionCountByName(userName));
        model.addAttribute("answerCount",profileService.getAnswerCountByName(userName));
        return "userProfile";
    }

//    @RequestMapping(value = "/showActivities", method = RequestMethod.GET)
//    @ResponseBody
//    List<ActivityVO> showActivities(@RequestParam("userName") String userName,Model model) {
//        return profileService.orderedActivity(profileService.getQuestionByName(userName),profileService.getAnswerByName(userName));
//    }
//
//    @RequestMapping(value = "/showQuestion", method = RequestMethod.GET)
//    @ResponseBody
//    List<QuestionVO> showUserQuestion(@RequestParam("userName") String userName) {
//        return profileService.getQuestionByName(userName);
//    }
//
//    @RequestMapping(value = "/showAnswers", method = RequestMethod.POST)
//    @ResponseBody
//    List<AnswerVO> showAnswers(@RequestParam("userName") String userName) {
//        return profileService.getAnswerByName(userName);
//    }

    @RequestMapping(value = "/showActivities")
    @ResponseBody
    Map<String,Object> showActivities(@RequestParam("userName") String userName,Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("activities",profileService.orderedActivity(profileService.getQuestionByName(userName),profileService.getAnswerByName(userName)));
        return map;
    }

    @RequestMapping(value = "/showQuestion")
    @ResponseBody
    Map<String,Object> showUserQuestion(@RequestParam("userName") String userName) {
        Map<String,Object> map = new HashMap<>();
        map.put("activities",profileService.getQuestionByName(userName));
        return map;
    }

    @RequestMapping(value = "/showAnswers")
    @ResponseBody
    Map<String,Object> showAnswers(@RequestParam("userName") String userName) {
        Map<String,Object> map = new HashMap<>();
        map.put("activities",profileService.getAnswerByName(userName));
        return map;
    }

    /**
     * 编辑用户信息
     * @param description  编辑后的用户描述
     * @param location 编辑后的用户地址
     * @param birthday 编辑后的用户生日
     * @param session {@link HttpSession}
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editProfile(@RequestParam("description") String description,
                            @RequestParam("location") String location,
                            @RequestParam("birthday") String birthday, HttpSession session){
        Object user = session.getAttribute("user");
        if (user!=null)
            profileService.editProfile((User)user, description, location, birthday);
    }
}
