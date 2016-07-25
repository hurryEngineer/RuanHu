package edu.nju.data.daoImpl.http;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.http.Wiki_httpDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Dora on 2016/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
public class Wiki_httpDAOImplTest {
    @Test
    public void getWikiById() throws Exception {
        System.out.println(dao.getWikiById(170));
    }


    @Test
    public void searchWikiByKeyword() throws Exception {
        System.out.println(dao.searchWikiByKeyword("a",1,1));
    }

    @Test
    public void addKeyMatch() throws Exception {
        System.out.println(dao.addKeyMatch("这样就可以通过测试了吗"));
    }

    @Autowired
    Wiki_httpDAO dao;

}