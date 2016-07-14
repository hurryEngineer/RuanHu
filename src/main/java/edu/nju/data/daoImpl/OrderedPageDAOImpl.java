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
        String hql = "from "+tableName+" ";
        return  execHQL(hql,pageNum,pageSize);
    }

    @Override
    public List<?> getPaginatedContent(String tableName, String where, int pageNum, int pageSize) {
        String hql = "from "+tableName+where;
        return  execHQL(hql,pageNum,pageSize);
    }

    @Override
    public List<?> getPaginatedContent(String tableName, int pageNum, int pageSize, OrderByPara orderByPara) {
        OrderByMethod method = OrderByMethod.DESC;

        String hql = getHQL(tableName,orderByPara,method);
        return execHQL(hql,pageNum,pageSize);
    }

    @Override
    public List<?> getPaginatedContent(String tableName, String where, int pageNum, int pageSize, OrderByPara orderByPara) {
        OrderByMethod method = OrderByMethod.DESC;

        String hql = getHQL(tableName,where,orderByPara,method);
        return execHQL(hql,pageNum,pageSize);
    }

    @Override
    public List<?> getPaginatedContent(String tableName, int pageNum, int pageSize, OrderByPara orderByPara, OrderByMethod orderByMethod) {

        String hql = getHQL(tableName,orderByPara,orderByMethod);
        return execHQL(hql,pageNum,pageSize);
    }

    @Override
    public List<?> getPaginatedContent(String tableName, String where, int pageNum, int pageSize, OrderByPara orderByPara, OrderByMethod orderByMethod) {
        String hql = getHQL(tableName,where,orderByPara,orderByMethod);
        return execHQL(hql,pageNum,pageSize);
    }


    @Override
    public String getHQL(String tableName, OrderByPara para, OrderByMethod method) {
        String orderPara =  getPara(para);
        String orderMethod= getMethod(method);
        String hql = "from "+tableName+para+method;
        return hql;
    }

    @Override
    public String getHQL(String tableName, String where, OrderByPara para, OrderByMethod method) {
        String orderPara =  getPara(para);
        String orderMethod= getMethod(method);
        String hql = "from "+tableName+" "+where+para+method;
        return hql;
    }

    private List<?> execHQL(String hql , int pageNum , int pageSize){
        Query query = em.createQuery(hql);
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
