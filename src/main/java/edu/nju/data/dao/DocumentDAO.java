package edu.nju.data.dao;


import java.util.List;

/**
 * Created by ss14 on 2016/7/20.
 */
public interface DocumentDAO {

    List getRelatedWikis(long docuID );

    List getRelatedQuestions(long docuID);


}
