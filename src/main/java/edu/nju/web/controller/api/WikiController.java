package edu.nju.web.controller.api;

import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.logic.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Controller
@RequestMapping("/api/wiki")
public class WikiController {

    @Autowired
    private WikiService wikiService;

    @RequestMapping("/entry/{id}")
    @ResponseBody
    public WikiItem getWikiById(@PathVariable long id) {
        return wikiService.getWikiById(id);
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<WikiItem> searchWikis(@RequestParam("key")String key, @RequestParam("page") int page) {
        return wikiService.searchWikis(key,page);
    }

    @RequestMapping(value = "/keymacth", method = RequestMethod.POST)
    @ResponseBody
    public String keyMatch(@RequestParam("content")String content) {
        return wikiService.keyMatch(content);
    }
}
