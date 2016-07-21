package edu.nju.web.controller.json;

import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
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
@RequestMapping("/json")
public class UserProfileJsonController {

    @Autowired
    private UserProfileService profileService;


    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    @ResponseBody
    List<User> getUserByNameKey(@RequestParam("key")String nameKey) {
        return profileService.getSearchUser(nameKey);
    }

    @RequestMapping(value = "/user/message", method = RequestMethod.GET)
    @ResponseBody
    List<Message> getUserMessage(@RequestParam("userId") long userId) {
        return profileService.getUserMessage(userId);
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
