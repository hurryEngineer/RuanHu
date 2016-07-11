package edu.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by cuihao on 2016/7/11.
 */
@Controller
@SessionAttributes("user")
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginVerify")
    @ResponseBody
    public String loginVerify(@RequestParam("account") String account, @RequestParam("password") String password,
                              Model model, HttpSession session){
        return null;
    }


}
