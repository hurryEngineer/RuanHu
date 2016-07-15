package edu.nju.data.dao;

import java.util.List;

/**
 * Created by ss14 on 2016/7/14.
 */
public interface OrderedPageDAO {


    List<?> execHQL(String hql , int pageNum , int pageSize);

    List<?> execHQL(String hql , int pageNum , int pageSize , Object arg);


}
