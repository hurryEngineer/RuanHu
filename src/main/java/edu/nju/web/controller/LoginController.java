package edu.nju.web.controller;

import edu.nju.data.entity.User;
import edu.nju.data.util.VerifyResult;
import edu.nju.logic.service.LoginService;
import edu.nju.logic.vo.LoginStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 登陆验证
     * @param username 登陆用户名
     * @param password 登录密码
     * @param model {@link Model}
     * @param session {@link HttpSession}
     * @return 登陆验证状态：成功，用户名不存在或密码错误
     *      {@link LoginStatus}
     */
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
