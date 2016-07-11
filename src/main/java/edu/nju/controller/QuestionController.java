package edu.nju.controller;

import edu.nju.model.MarkedText;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Dora on 2016/7/11.
 */

@Controller
@RequestMapping("/question")
public class QuestionController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    Question showQuestion(@PathVariable Long id){return null;}

    @RequestMapping(value = "/ask",method = RequestMethod.POST)
    void newQuestion(String title, MarkedText description, String tagNames, boolean watching,
                     List<Long> attachmentsIds){}

    @RequestMapping(value = "/ask",method = RequestMethod.GET)
    void newQuestion(){}

}
