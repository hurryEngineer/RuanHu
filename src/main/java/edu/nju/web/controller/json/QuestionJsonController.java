package edu.nju.web.controller.json;

import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.QuestionService;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dora on 2016/7/11.
 */

@Controller
@SessionAttributes("user")
@RequestMapping("/json")
public class QuestionJsonController {

    @Autowired
    QuestionService service;

    @Autowired
    TransferService timeService;



    @RequestMapping(value = "/question/get", method = RequestMethod.GET)
    @ResponseBody
    QuestionVO getQuestion(@RequestParam("id")String questionId, HttpSession session) {
        Object user = session.getAttribute("user");
        return service.showQuestion(Long.valueOf(questionId),user==null?-1:((User)user).getId());
    }
    
    @RequestMapping(value="/question/{id}/answers",method = RequestMethod.GET)
    @ResponseBody
    List<AnswerVO> showAnswers(@PathVariable long id, @RequestParam(value = "page", defaultValue = "1") int page, HttpSession session) {

        Object user = session.getAttribute("user");

        return service.getAnswers(id, page, 10, user==null?-1:((User)user).getId());
    }


    /**
     * 投票：赞同票
     * @param questionId 问题id
     * @param userId 用户id
     * @return 如果之前没有投过赞同票，票数增加1，返回 1
     *          如果之前投过赞同票，票数减少1， 返回 -1
     *          如果之前投的反对票，票数增加2，返回 2
     */
    @RequestMapping(value = "/up")
    @ResponseBody
    int upVote(String questionId, String userId){
        return service.vote(questionId,userId, VoteType.up);
    }

    /**
     * 投票：反对票
     * @param questionId 问题id
     * @param userId 用户id
     * @return 投票后的总票数
     */
    @RequestMapping(value = "/down")
    @ResponseBody
    int downVote(String questionId, String userId){
        return service.vote(questionId,userId, VoteType.down);
    }


}
