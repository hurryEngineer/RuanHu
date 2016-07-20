package edu.nju.logic.impl;

import edu.nju.data.dao.DocumentDAO;
import edu.nju.data.dao.WikiDAO;
import edu.nju.logic.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Component
public class RelationImpl implements RelationService {

    @Autowired
    private WikiDAO wikiDAO;

    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public List getRelatedDocByWiki(long wikiId) {
        return wikiDAO.getRelatedDocuments(wikiId);
    }

    @Override
    public List getRelatedQuestionByWiki(long wikiId) {
        return wikiDAO.getRelatedQuestions(wikiId);
    }

    @Override
    public List getRelatedWikiByDoc(long docId) {
        return documentDAO.getRelatedWikis(docId);
    }

    @Override
    public List getRelatedQuestionByDoc(long docId) {
        return documentDAO.getRelatedQuestions(docId);
    }
}
