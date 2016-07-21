package edu.nju.web.controller;

import edu.nju.logic.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by cuihao on 2016/7/21.
 */
@Controller
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    public String invite(String questionId, String userId, List<String> inviteNames) {
        inviteService.inivite(Long.valueOf(questionId),Long.valueOf(userId),inviteNames);
        return "redirect:/question/"+questionId;
    }
}
