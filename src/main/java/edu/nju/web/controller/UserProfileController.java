package edu.nju.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cuihao on 2016/7/12.
 */
@Controller
@RequestMapping("/userProfile")
public class UserProfileController {
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public String showProfile(){
        return "userProfile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editProfile(@RequestParam("description") String description,
                            @RequestParam("location") String location,
                            @RequestParam("birthday") String birthday){

    }
}
