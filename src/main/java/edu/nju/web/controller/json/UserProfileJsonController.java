package edu.nju.web.controller.json;

import edu.nju.data.entity.User;
import edu.nju.logic.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
