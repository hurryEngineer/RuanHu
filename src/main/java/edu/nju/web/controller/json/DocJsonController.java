package edu.nju.web.controller.json;

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
@RequestMapping("/json/doc")
public class DocJsonController {

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
}
