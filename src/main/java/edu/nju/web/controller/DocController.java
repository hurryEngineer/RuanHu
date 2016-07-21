package edu.nju.web.controller;

import edu.nju.data.entity.api.Document;
import edu.nju.logic.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Controller
@RequestMapping("/doc")
public class DocController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    public void sendMessage(@RequestParam("message")String message, @RequestParam("name") String userName,
                            @RequestParam("id") String userId){
        documentService.sendMessage(userName,message,userId);
    }
}
