package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ss14 on 2016/7/12.
 */
@Repository
@Transactional
public class BaseDAOImpl implements BaseDAO {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void insert(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void load(Class<?> c, int id) {

    }

    @Override
    public boolean contains(Object obj) {
        return false;
    }
}
