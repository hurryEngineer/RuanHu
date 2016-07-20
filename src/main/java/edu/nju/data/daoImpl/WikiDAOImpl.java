package edu.nju.data.daoImpl;

import edu.nju.data.dao.WikiDAO;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.Pager;

import java.awt.*;

/**
 * Created by ss14 on 2016/7/20.
 */
public class WikiDAOImpl implements WikiDAO {
    @Override
    public List getRelatedQuestions(long wikiID) {
        return null;
    }

    @Override
    public List getRelatedDocuments(long wikiID) {
        return null;
    }

    @Override
    public WikiItem getWikiById(long id) {
        return null;
    }

    @Override
    public Pager<WikiItem> searchWikiByKeyword(String keyword, int page, int size) {
        return null;
    }

    @Override
    public String addKeyMatch(String content) {
        return null;
    }
}
