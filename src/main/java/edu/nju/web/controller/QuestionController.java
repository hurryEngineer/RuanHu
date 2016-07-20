package edu.nju.web.controller;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.QuestionService;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class QuestionController {

    @Autowired
    QuestionService service;

    @Autowired
    TimeService timeService;

    @RequestMapping(value="/question",method = RequestMethod.GET)
    String showAllQuestions(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        List<QuestionVO> result = service.getQuestions(page,10);
        model.addAttribute("questions",result);

        return "questionList";
    }

    
    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    String showQuestion(@PathVariable long id, Model model, HttpSession session,SessionStatus sessionStatus){

        Object question = session.getAttribute("question");
        Question ques = question==null?service.showQuestion(id):(Question)question;
        
        session.setAttribute("question", null);
        
        List<AnswerVO> answerVOs = service.getAnswers(ques.getId(), 1, 10);

        model.addAttribute("question",ques);
        model.addAttribute("answerOfQuestion",answerVOs);

        return "questionInfo";
        
    }
    
    @RequestMapping(value="/question/{id}/answers",method = RequestMethod.GET)
    @ResponseBody
    List<AnswerVO> showAnswers(@PathVariable long id, @RequestParam(value = "page", defaultValue = "1") int page) {

        return service.getAnswers(id, page, 10);
    }

    
    @RequestMapping(value = "/submitQuestion",method = RequestMethod.POST)
    String newQuestion(String title, String description, HttpSession session, @ModelAttribute("user")User user){
        System.out.println("submit a question!");
        Map<String,Object> result = new HashMap<>();
        Question question;

        if(user!=null) {

            question = new Question();
            question.setTitle(title);

            question.setAuthor(user);
            question.setLastUpdatedAt(new Timestamp(new Date().getTime()));
            question.setCreatedAt(new Timestamp(new Date().getTime()));
            question.setContent(description);

            question = service.saveQuestion(question);
            QuestionVO questionVO = timeService.transferQuestion(question);
            session.setAttribute("question",questionVO);


            return "redirect:/question/"+question.getId();
        }

        return "redirect:/ask";
    }

    @RequestMapping(value = "/ask",method = RequestMethod.GET)
    String newQuestion(){
        return "askQuestion";
    }

    @RequestMapping(value = "/up")
    boolean upVote(String questionId, String userId){
        return service.vote(questionId,userId, VoteType.up);
    }

    @RequestMapping(value = "/down")
    boolean downVote(String questionId, String userId){
        return service.vote(questionId,userId, VoteType.down);
    }


}
