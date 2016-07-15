package edu.nju.data.util.HQL_Helper.Interfaces;

/**
 * Created by ss14 on 2016/7/15.
 */


import edu.nju.data.util.HQL_Helper.Enums.WherePara;

/**
 * 专用来生成where hql 语句
 */
public interface WhereHQLInterface {

    String getWhereHql(WherePara wherePara , long...args );

    String getWhereHql(WherePara wherePara , String...args );

}
