package edu.nju.data.dao;


import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */


public interface BaseDAO {
    /**
     * 向数据库中插入对象,不检查是否有重复
     * @param obj
     */
    void insert(Object obj);

    /**
     * 从数据库中删除对象
     * @param
     * @return
     */
    void delete(Class<?> c,long id);

    /**
     * 更新数据库中的对象
     * @param obj
     */
    void update(Object obj);

    /**
     * 加载一个对象
     * @param c   e.g load(Answer.class , 1)
     * @param id
     */
    Object load(Class<?> c, long id);


}
