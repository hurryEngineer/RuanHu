package edu.nju.web.controller;
import edu.nju.data.entity.User;
import edu.nju.data.util.VerifyResult;
import edu.nju.logic.service.LoginService;

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
        VerifyResult result =  loginService.verifyLogin(account, password);
        switch (result) {
            case INEXISTENCE: return "用户不存在!";
            case INCORRECT: return "密码错误!";
            default:
                User users = loginService.getCurrentUser(account);
                session.setAttribute("user",users);
                model.addAttribute("user",users);
                return account;
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "";
    }


}
