package edu.nju.web.controller;

import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.api.WikiItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Controller
@RequestMapping("/api")
public class WikiController {

    @Autowired
    private Wiki_httpDAO wiki_httpDAO;

    @RequestMapping("/entry/{id}")
    @ResponseBody
    public WikiItem getWikiById(@PathVariable long id) {
        WikiItem wikiItem = new WikiItem();
        try {
            wikiItem = wiki_httpDAO.getWikiById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wikiItem;
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<WikiItem> searchWikis(@RequestParam("key")String key) {
        return null;
    }

    @RequestMapping(value = "/keymacth", method = RequestMethod.POST)
    @ResponseBody
    public String keyMatch(@RequestParam("content")String content) {
        return null;
    }
}
