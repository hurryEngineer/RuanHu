package edu.nju.web.controller;

import edu.nju.logic.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cuihao on 2016/7/21.
 */
@Controller
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    @ResponseBody void invite(String questionId, String userId,
                              @RequestParam(value="inviteIds",defaultValue="")List<Long> inviteIds) {
        inviteService.inivite(Long.valueOf(questionId),Long.valueOf(userId),inviteIds);
//        return "redirect:/question/"+questionId;
    }

}
