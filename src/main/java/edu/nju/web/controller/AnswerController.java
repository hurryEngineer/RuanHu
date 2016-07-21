package edu.nju.web.controller;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.User;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.AnswerService;
import edu.nju.logic.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/answer")
@SessionAttributes("user")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    /**
     * 将答案的内容临时保存在session里
     * @param questionId 答案对应的问题编号
     * @param markedText 答案临时保存的内容
     * @param session {@link HttpSession}
     */
    @RequestMapping("/tempSave")
    public void tempSave(@RequestParam("questionId") String questionId,
                         @RequestParam("markedText") String markedText, HttpSession session) {
        Answer answer = getTempAnswer(questionId, session);
        answer.setContent(markedText);
        ((Map<String,Answer>)session.getAttribute("tempAnswer")).put(questionId, answer);
    }

    /**
     * 获取保存在session里的answer<br>
     *     若answer里没有answer这个map，就新建一个
     *     若map里没有指定id的answer，则新建一个空的answer
     * @param questionId 回答的问题的id
     * @param session {@link HttpSession}
     * @return {@link Answer}
     */
    @RequestMapping("/getTempAnswer")
    public AnswerVO getTempAnswer(@RequestParam("questionId") String questionId, HttpSession session) {
        Object answer = session.getAttribute("tempAnswer");
        if (answer!=null) {
            Map<String, AnswerVO> answerMap =  (Map<String,AnswerVO>) answer;
            return answerMap.containsKey(questionId)? answerMap.get(questionId):new AnswerVO(new Answer());
        } else {
            Map<String, AnswerVO> answerMap = new HashMap<>();
            session.setAttribute("tempAnswer", answerMap);
            return new AnswerVO(new Answer());
        }
    }

    /**
     * 修改一个回答
     * @param questionId 问题id
     * @param answerId 回答id
     * @param text 修改后的回答内容
     * @return 跳转到原问题界面
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editAnswer(@RequestParam("qid")String questionId, @RequestParam("aid")String answerId,
                           @RequestParam("text")String text) {
        answerService.editAnswer(Long.valueOf(answerId),text);
        return "redirect:/question/"+questionId;
    }

    /**
     * 删除答案
     * @param answerId 答案id
     * @param userId 用户id
     * @param questionId 问题id
     * @param model {@link Model}
     * @return 有权限删除model里添加true， 没有权限则为false，跳转回原问题界面
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteAnswer(@RequestParam("aid") String answerId, @RequestParam("userId") String userId,
                               @RequestParam("qid")String questionId, Model model) {
        boolean result = answerService.deleteAnswer(Long.valueOf(answerId),Long.valueOf(userId));
        model.addAttribute("deleteResult",result);
        return "redirect:/question/"+questionId;
    }


}
