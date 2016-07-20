package edu.nju.logic.impl;

import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.Pager;
import edu.nju.logic.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Component
public class WikiImpl implements WikiService {

    @Autowired
    private Wiki_httpDAO wiki_httpDAO;

    @Override
    public WikiItem getWikiById(long id) {
        WikiItem wikiItem = null;
        try {
            wikiItem = wiki_httpDAO.getWikiById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wikiItem;
    }

    @Override
    public List<WikiItem> searchWikis(String key,int page) {
        Pager<WikiItem> wikiItemPager = null;
        try {
            wikiItemPager = wiki_httpDAO.searchWikiByKeyword(key,page,10);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<WikiItem> wikiItems = new ArrayList<>();
        if (wikiItemPager!=null){
            wikiItems = wikiItemPager.getData();
        }
        return wikiItems;
    }

    @Override
    public String keyMatch(String content) {
        String result = content;
        try {
            result = wiki_httpDAO.addKeyMatch(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
