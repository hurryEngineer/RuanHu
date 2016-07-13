package edu.nju.web.controller;

import edu.nju.data.entity.User;
import edu.nju.data.util.VerifyResult;
import edu.nju.logic.service.LoginService;
import edu.nju.web.vo.LoginStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * 
 * Created by cuihao on 2016/7/11.
 */
@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(String formerUrl, HttpSession session) {
        session.setAttribute("formerUrl", formerUrl);
        return "login";
    }

    @RequestMapping("/loginVerify")
    @ResponseBody
    public LoginStatus loginVerify(@RequestParam("username") String username,
            @RequestParam("password") String password, Model model,
            HttpSession session) {
        VerifyResult result = loginService.verifyLogin(username, password);
        LoginStatus status = new LoginStatus();
        if (result.equals(VerifyResult.SUCCESS)) {
            User users = loginService.getCurrentUser(username);
            session.setAttribute("user", users);
            model.addAttribute("user", users);

            status.setResult(result);
            status.setFormerUrl(session.getAttribute("formerUrl").toString());
            return status;
        }

        status.setResult(result);
        return status;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "";
    }

}
