package edu.nju.web.controller;

import edu.nju.data.entity.Question;
import edu.nju.data.entity.User;
import edu.nju.logic.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dora on 2016/7/11.
 */

@Controller
public class QuestionController {

    @Autowired
    QuestionService service;

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    String showQuestion(@PathVariable long id, Model model, HttpSession session){
        Object question = session.getAttribute("question");
        Question ques = question==null?service.showQuestion(id):(Question)question;
        model.addAttribute("question",ques);
        return "test";
    }

    @RequestMapping(value = "/submitQuestion")
    String newQuestion(String title, String description, HttpSession session){

        Object userAttr = session.getAttribute("user");
        Map<String,Object> result = new HashMap<>();
        Question question;

        if((userAttr = session.getAttribute("user"))!=null) {

            question = new Question();
            question.setTitle(title);

            User user = (User)userAttr;
            question.setAuthorId(user.getId());
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
        return "test";
    }



}
