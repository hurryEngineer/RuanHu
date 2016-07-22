package edu.nju.web.controller.api;

import edu.nju.logic.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * 对外提供的api
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private RelationService relationService;

    @RequestMapping(value = "/relation/ppt/{id}", method = RequestMethod.GET)
    @ResponseBody
    Map<String, Object> getPPTRelation(@PathVariable long id){
        Map<String,Object> map = new HashMap<>();
        map.put("pptId",id);
        map.put("wikiIds", relationService.getRelatedWikiByDoc(id));
        map.put("questionIds", relationService.getRelatedQuestionByDoc(id));
        return map;
    }

    @RequestMapping(value = "/relation/wiki/{id}",method = RequestMethod.GET)
    @ResponseBody
    Map<String, Object> getWikiRelation(@PathVariable long id){
        Map<String, Object> map = new HashMap<>();
        map.put("wikiId", id);
        map.put("pptIds", relationService.getRelatedDocByWiki(id));
        map.put("questionIds", relationService.getRelatedQuestionByWiki(id));
        return map;
    }

    @RequestMapping(value = "/ask",method = RequestMethod.GET)
    @ResponseBody
    String askQuestionByWiki(@RequestParam("wikiId")String wikiId) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip = "localhost:8080";
        if (inetAddress!=null) {
            ip = inetAddress.getHostAddress();
        }
        return ip+":8080/ask?wikiId="+wikiId;
    }
}
