package edu.nju.logic.impl;

import edu.nju.RuanHuApplication;
import edu.nju.logic.service.TimeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2016/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class TimeImplTest {

    @Autowired
    private TimeService timeService;

    @Test
    public void timeToString() throws Exception {
        Calendar test = Calendar.getInstance();
        test.set(Calendar.MINUTE, test.get(Calendar.MINUTE)-10);
        Assert.assertTrue(timeService.timeToString(new Timestamp(test.getTimeInMillis())).equals("10分钟之前"));
        test.setTimeInMillis(test.getTimeInMillis()-3600000);
        System.out.println(timeService.timeToString(new Timestamp(test.getTimeInMillis())));
        test.set(Calendar.DATE,test.get(Calendar.DATE)-1);
        test.setTimeInMillis(test.getTimeInMillis()+7200000);
        System.out.println(timeService.timeToString(new Timestamp(test.getTimeInMillis())));
        test.set(Calendar.DATE,test.get(Calendar.DATE)-1);
        System.out.println(timeService.timeToString(new Timestamp(test.getTimeInMillis())));
        test.set(Calendar.YEAR,test.get(Calendar.YEAR)-1);
        System.out.println(timeService.timeToString(new Timestamp(test.getTimeInMillis())));
    }

}