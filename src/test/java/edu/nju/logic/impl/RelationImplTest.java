package edu.nju.logic.impl;

import edu.nju.RuanHuApplication;
import edu.nju.logic.service.RelationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2016/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
@Rollback
@Transactional
public class RelationImplTest {

    @Autowired
    private RelationService relationService;

    @Test
    public void getRelatedDocByWiki() throws Exception {
        Assert.assertTrue(relationService.getRelatedDocByWiki(1).size()>0);
    }

    @Test
    public void getRelatedQuestionByWiki() throws Exception {
        Assert.assertTrue(relationService.getRelatedQuestionByWiki(1).size()>0);
    }

    @Test
    public void getRelatedWikiByDoc() throws Exception {
        Assert.assertTrue(relationService.getRelatedWikiByDoc(1).size()>0);
    }

    @Test
    public void getRelatedQuestionByDoc() throws Exception {
        Assert.assertTrue(relationService.getRelatedQuestionByDoc(1).size()>0);
    }

}