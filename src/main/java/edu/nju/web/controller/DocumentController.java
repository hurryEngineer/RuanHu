package edu.nju.web.controller;

import edu.nju.data.entity.api.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Controller
@RequestMapping("/api")
public class DocumentController {
    @RequestMapping("/ppt/{id}")
    @ResponseBody
    public Document getDocById(@PathVariable long id){
        return null;
    }
    @RequestMapping("/ppt/")
    @ResponseBody
    public List<Document> searchDocuments(){
        return null;
    }
}
