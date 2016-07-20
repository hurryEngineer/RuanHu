package edu.nju.data.dao;

import java.awt.*;

/**
 * Created by ss14 on 2016/7/20.
 */
public interface WikiDAO {

    List getRelatedQuestions(Long wikiID);

    List getRelatedDocuments(Long wikiID);

}
