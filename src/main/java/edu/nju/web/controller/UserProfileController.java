package edu.nju.web.controller;

import edu.nju.data.entity.User;
import edu.nju.logic.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by cuihao on 2016/7/12.
 */
@Controller
@RequestMapping("/userProfile")
public class UserProfileController {
    @Autowired
    private UserProfileService profileService;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public User showProfile(HttpSession session){
        Object user =  session.getAttribute("user");
        if (user == null) {
            return null;
        } else {
            return (User) user;
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editProfile(@RequestParam("description") String description,
                            @RequestParam("location") String location,
                            @RequestParam("birthday") String birthday, HttpSession session){
        Object user = session.getAttribute("user");
        if (user!=null)
            profileService.editProfile((User)user, description, location, birthday);
    }
}
