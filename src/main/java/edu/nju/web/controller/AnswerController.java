package edu.nju.web.controller;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.User;
import edu.nju.logic.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/tempSave")
    public void tempSave(@RequestParam("questionId") String questionId,
                         @RequestParam("markedText") String markedText, HttpSession session) {
        Answer answer = getTempAnswer(questionId, session);
        answer.setContent(markedText);
        ((Map<String,Answer>)session.getAttribute("tempAnswer")).put(questionId, answer);
    }

    @RequestMapping("/getTempAnswer")
    public Answer getTempAnswer(@RequestParam("questionId") String questionId, HttpSession session) {
        Object answer = session.getAttribute("tempAnswer");
        if (answer!=null) {
            Map<String, Answer> answerMap =  (Map<String,Answer>) answer;
            return answerMap.containsKey(questionId)? answerMap.get(questionId):new Answer();
        } else {
            Map<String, Answer> answerMap = new HashMap<>();
            session.setAttribute("tempAnswer", answerMap);
            return new Answer();
        }
    }

    @RequestMapping(value = "/newAnswer", method = RequestMethod.GET)
    @ResponseBody
    public String  newAnswer(){
        return "newAnswer";
    }

    @RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
    @ResponseBody
    public boolean saveAnswer(String questionId, String markedtext, HttpSession session){
        User user = (User) session.getAttribute("user");
        return answerService.saveAnswer(Long.valueOf(questionId), user.getId(), markedtext);
    }

    @RequestMapping(value = "/markAsSolution")
    @ResponseBody
    public boolean markAsSolution(String answerId,String questionId, HttpSession session){
        User user = (User) session.getAttribute("user");
        return answerService.markAsSolution(user, Long.valueOf(questionId), Long.valueOf(answerId));
    }

}
