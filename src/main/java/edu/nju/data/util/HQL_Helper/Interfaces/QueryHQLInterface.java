package edu.nju.data.util.HQL_Helper.Interfaces;

import edu.nju.data.util.HQL_Helper.Enums.FromPara;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;

/**
 * Created by ss14 on 2016/7/15.
 * 由于where字段的特殊性，很难做到考虑周全，简单的判断难以解决
 * 所以，目前的接口暂时用作 Question / Answer / comment 的查询(分页排序)使用
 * 他们有许多共同点: 都含有 author / createdAt /lastUpdatedAt 属性
 */
public interface QueryHQLInterface {

    String getHQLby
            (FromPara tableName , WherePara wherePara);

    String getHQLby
            (FromPara tableName , WherePara wherePara , OrderByPara orderByPara , OrderByMethod  orderByMethod);


}
