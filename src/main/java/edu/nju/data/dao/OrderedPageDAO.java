package edu.nju.data.dao;

import edu.nju.data.util.OrderByMethod;
import edu.nju.data.util.OrderByPara;

import java.util.List;

/**
 * Created by ss14 on 2016/7/14.
 */
public interface OrderedPageDAO {


    String getHQL(String tableName ,OrderByPara para ,OrderByMethod method);

    String getHQL(String tableName ,String where ,OrderByPara para ,OrderByMethod method);


    /**
     * 获取某个表中的某页，不排序，random
     * @param tableName
     * @param pageNum    页号
     * @param pageSize   页面大小
     * @return
     */
    List<?> getPaginatedContent(String tableName , int pageNum , int pageSize);
    List<?> getPaginatedContent(String tableName ,String where, int pageNum , int pageSize);
    /**
     * 多了按某种方式排序的参数，默认降序排序，即获取最近时间的，数量最大的
     * @param tableName
     * @param pageNum
     * @param pageSize
     * @param orderByPara  详情见OrderByPara类
     * @return
     */

    List<?> getPaginatedContent(String tableName , int pageNum ,
                                    int pageSize, OrderByPara orderByPara);

    List<?> getPaginatedContent(String tableName ,String where, int pageNum ,
                                int pageSize, OrderByPara orderByPara);
    /**
     * 多了排序方式，升序还是降序
     * @param tableName
     * @param pageNum
     * @param pageSize
     * @param orderByPara
     * @param orderByMethod
     * @return
     */
    List<?> getPaginatedContent(String tableName , int pageNum ,
                                    int pageSize, OrderByPara orderByPara ,
                                        OrderByMethod orderByMethod);

    List<?> getPaginatedContent(String tableName ,String where, int pageNum ,
                                int pageSize, OrderByPara orderByPara ,
                                OrderByMethod orderByMethod);

}
