package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by ss14 on 2016/7/20.
 */
@Repository
@Transactional
public class DocumentDAOImpl implements DocumentDAO {
    @Autowired
    private BaseDAO baseDAO;
    @PersistenceContext
    private EntityManager em;


    @Override
    public List getRelatedWikis(long docuID) {
        return null;
    }

    @Override
    public List getRelatedQuestions(long docuID) {
        return null;
    }
}
