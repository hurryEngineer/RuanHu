package edu.nju.data.dao;


import java.util.List;

/**
 * Created by ss14 on 2016/7/12.
 */


public interface BaseDAO {
    /**
     * 向数据库中插入对象
     * @param obj
     */
    void insert(Object obj);

    /**
     * 从数据库中删除对象
     * @param obj
     * @return
     */
    void delete(Object obj);

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
    void load(Class<?> c, int id);


    /**
     *
     */
    boolean contains(Object obj);




}
