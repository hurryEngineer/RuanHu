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
        em.persist(obj);
    }

    @Override
    public void delete( Class<?> c, long id) {
        Object ob =load(c,id);
        em.remove(ob);

    }

    @Override
    public void update(Object obj) {
        em.merge(obj);
    }

    @Override
    public Object load(Class<?> c, long id) {
            return em.find(c,id);
    }


}
