package edu.nju.data.daoImpl;

import edu.nju.data.dao.OrderedPageDAO;
import edu.nju.data.util.OrderByMethod;
import edu.nju.data.util.OrderByPara;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ss14 on 2016/7/14.
 */
@Repository
@Transactional
public class OrderedPageDAOImpl implements OrderedPageDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<?> getPaginatedContent(String tableName, int pageNum, int pageSize) {
        Query query = em.createQuery("from "+tableName+" ");
        query.setFirstResult((pageNum-1) * pageSize);
        query.setMaxResults(pageSize);
        List <?> rows = query.getResultList();
        return rows;
    }

    @Override
    public List<?> getPaginatedContent(String tableName, int pageNum, int pageSize, OrderByPara orderByPara) {
        String orderPara =  getPara(orderByPara);
        String orderMethod= " desc";

        Query query = em.createQuery("from "+tableName+orderPara+orderMethod);
        query.setFirstResult((pageNum-1) * pageSize);
        query.setMaxResults(pageSize);
        List <?> rows = query.getResultList();
        return rows;
    }

    @Override
    public List<?> getPaginatedContent(String tableName, int pageNum, int pageSize, OrderByPara orderByPara, OrderByMethod orderByMethod) {
        String orderPara =  getPara(orderByPara);
        String orderMethod= getMethod(orderByMethod);

        Query query = em.createQuery("from "+tableName+orderPara+orderMethod);
        query.setFirstResult((pageNum-1) * pageSize);
        query.setMaxResults(pageSize);
        List <?> rows = query.getResultList();
        return rows;
    }



    private String getPara(OrderByPara orderByPara){
        String orderPara=" order by ";
        switch(orderByPara){

            case createdAt:
                orderPara+="createdAt";
                break;
            case lastUpdatedAt:
                orderPara+="lastUpdatedAt";
                break;
            case viewCount:
                orderPara+="viewCount";
                break;
            case voteCount:
                orderPara+="voteCount";
                break;
            case answerCount:
                orderPara+="answerCount";
                break;
        }
        return orderPara;
    }


    private String getMethod(OrderByMethod orderByMethod){
        String orderMethod= " ";
        if(orderByMethod==OrderByMethod.ASC){
            orderMethod+="asc";
        }else{
            orderMethod+="desc";
        }
        return orderMethod;
    }
}
