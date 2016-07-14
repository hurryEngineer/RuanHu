package edu.nju.web.controller;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/questions",method = RequestMethod.GET)
    String showAllQuestions(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

        List<Question> result = service.getQuestions(page,10);
        model.addAttribute("questions",result);

        return "questionPage";
    }


    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    String showQuestion(@PathVariable long id, Model model, HttpSession session){

        Object question = session.getAttribute("question");
        Question ques = question==null?service.showQuestion(id):(Question)question;

        model.addAttribute("question",ques);

        return "test";
    }

    @RequestMapping(value="/queation/{id}/answers",method = RequestMethod.GET)
    @ResponseBody
    List<Answer> showAnswers(@PathVariable long id, @RequestParam(value = "page", defaultValue = "1") int page) {

        return service.getAnswers(id, page, 10);
    }

    @RequestMapping(value = "/submitQuestion")
    String newQuestion(String title, String description, HttpSession session, @ModelAttribute("user")User user){

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
            session.setAttribute("question",question);


            return "redirect:/question/"+question.getId();
        }


        return "redirect:/ask";

    }

    @RequestMapping(value = "/ask",method = RequestMethod.GET)
    String newQuestion(){
        return "editQuestion";
    }



}
