package edu.nju.web.controller;

import edu.nju.data.entity.MarkedText;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cuihao on 2016/7/12.
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {

    @RequestMapping("/tempSave")
    public void tempSave(String questionId, String answerId,  MarkedText description, String tagNames, boolean watching,
                         List<Long> attachmentsIds, HttpSession session){
    }

    @RequestMapping(value = "/newAnswer", method = RequestMethod.GET)
    @ResponseBody
    public String  newAnswer(){
        return "newAnswer";
    }

    @RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
    @ResponseBody
    public String saveAnswer(String questionId, MarkedText description,boolean watching,
                             List<Long> attachmentsIds){
        return "";
    }

    @RequestMapping(value = "/markAsSolution")
    public void markAsSolution(String answerId){
    }

}
