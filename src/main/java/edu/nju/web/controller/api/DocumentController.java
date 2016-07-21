package edu.nju.web.controller.api;

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
@RequestMapping("/api/doc")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/ppt/{id}")
    @ResponseBody
    public Document getDocById(@PathVariable long id){
        return documentService.getDocById(id);
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<Document> searchDocuments(@RequestParam("key")String key, @RequestParam("page") int page){
        return documentService.searchDocuments(key,page);
    }
    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    public void sendMessage(@RequestParam("message")String message, @RequestParam("name") String userName,
                            @RequestParam("id") String userId){
        documentService.sendMessage(userName,message,userId);
    }
}
