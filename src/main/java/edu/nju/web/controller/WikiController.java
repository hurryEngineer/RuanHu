package edu.nju.web.controller;

import edu.nju.data.entity.api.WikiItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Controller
@RequestMapping("/api")
public class WikiController {
    @RequestMapping("/entry/{id}")
    @ResponseBody
    public WikiItem getWikiById(@PathVariable long id) {
        return null;
    }

    @RequestMapping("/api/search")
    @ResponseBody
    public List<WikiItem> searchWikis(@RequestParam("key")String key) {
        return null;
    }
}
