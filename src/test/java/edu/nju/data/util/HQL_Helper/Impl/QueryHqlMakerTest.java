package edu.nju.data.util.HQL_Helper.Impl;

import edu.nju.RuanHuApplication;
import edu.nju.data.util.HQL_Helper.Enums.FromPara;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
public class QueryHqlMakerTest {

    @Autowired
    QueryHqlMaker maker;


    @Test
    public void getHQLby() throws Exception {

        String hql = maker.getHQLby(FromPara.Answer , null);
        System.err.println("hql:  "+hql);

    }

    @Test
    public void getHQLby1() throws Exception {
        String hql = maker.getHQLby(FromPara.Answer , null , OrderByPara.createdAt, OrderByMethod.ASC);
        System.err.println("hql:  "+hql);
    }


}