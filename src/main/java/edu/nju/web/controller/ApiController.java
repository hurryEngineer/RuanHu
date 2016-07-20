package edu.nju.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 对外提供的api
 */
@Controller
@RequestMapping("/api/relation")
public class ApiController {
    @RequestMapping(value = "/ppt/{id}", method = RequestMethod.GET)
    @ResponseBody
    Map<String, Object> getPPTRelation(@PathVariable long id){
        return null;
    }

    @RequestMapping(value = "/wiki/{id}",method = RequestMethod.GET)
    @ResponseBody
    Map<String, Object> getWikiRelation(@PathVariable long id){
        return null;
    }
}
