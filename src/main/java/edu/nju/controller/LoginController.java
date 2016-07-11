package edu.nju.controller;

import edu.nju.model.Users;
import edu.nju.modelService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginVerify")
    @ResponseBody
    public String loginVerify(@RequestParam("account") String account, @RequestParam("password") String password,
                              Model model, HttpSession session){
        Users user =  loginService.verifyLogin(account, password);
        if (user!=null) {
            session.setAttribute("user",user);
            model.addAttribute("user",user);
            return user.getId()+"";
        } else {
           return "login failed";
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        return "";
    }


}
