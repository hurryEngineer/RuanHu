package edu.nju.web.controller;

import edu.nju.data.entity.User;
import edu.nju.data.util.VerifyResult;
import edu.nju.logic.service.LoginService;
import edu.nju.logic.vo.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
    public String login(@RequestParam(defaultValue="") String formerUrl, HttpSession session) {
        if(!formerUrl.equals("")) {
            session.setAttribute("formerUrl", formerUrl);
        }
        return "login";
    }

    /**
     * 注销登陆
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(String formerUrl, HttpSession session,SessionStatus sessionStatus) {
        session.removeAttribute("user");
//        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:"+formerUrl;
    }

    
}
