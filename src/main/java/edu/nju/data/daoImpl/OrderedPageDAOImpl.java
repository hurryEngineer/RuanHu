package edu.nju.data.daoImpl;

import edu.nju.data.dao.OrderedPageDAO;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * Created by ss14 on 2016/7/14.
 */
@Repository
@Transactional
public class OrderedPageDAOImpl implements OrderedPageDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<?> execHQL(String hql , int pageNum , int pageSize){

        Query query = em.createQuery(hql);
        query.setFirstResult((pageNum-1) * pageSize);
        query.setMaxResults(pageSize);
        List <?> rows = query.getResultList();
        return rows;
    }

    @Override
    public List<?> execHQL(String hql , int pageNum , int pageSize , Object arg){

        Query query = em.createQuery(hql);
        query.setParameter(1,arg);
        query.setFirstResult((pageNum-1) * pageSize);
        query.setMaxResults(pageSize);
        List <?> rows = query.getResultList();
        return rows;
    }


}
