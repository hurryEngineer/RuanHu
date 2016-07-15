package edu.nju.data.util.HQL_Helper.Impl;

import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;
import edu.nju.data.util.HQL_Helper.Interfaces.QueryHQLInterface;

/**
 * Created by ss14 on 2016/7/15.
 */


public class QueryHqlMaker implements QueryHQLInterface {


    @Override
    public String getHQLby(String tableName, WherePara wherePara, long... args) {
        return null;
    }

    @Override
    public String getHQLby(String tableName, WherePara wherePara, String... args) {
        return null;
    }

    @Override
    public String getHQLby(String tableName, WherePara wherePara, OrderByPara orderByPara, OrderByMethod orderByMethod, long... args) {
        return null;
    }

    @Override
    public String getHQLby(String tableName, WherePara wherePara, OrderByPara orderByPara, OrderByMethod orderByMethod, String... args) {
        return null;
    }
}
