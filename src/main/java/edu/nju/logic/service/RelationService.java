package edu.nju.logic.service;

import java.util.List;

/**
 * api logic service
 */
public interface RelationService {
    List getRelatedDocByWiki(long wikiId);
    List getRelatedQuestionByWiki(long wikiId);
    List getRelatedWikiByDoc(long docId);
    List getRelatedQuestionByDoc(long docId);
}
