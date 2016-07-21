package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.OrderedPageDAO;
import edu.nju.data.entity.Question;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/14.
 */

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
@Rollback
public class OrderedPageDAOImplTest {
    @Autowired
    OrderedPageDAO dao;


    @Test
    public void getPaginatedContent() throws Exception {

//        String tableName = "Question";
//        int pageNum=1;
//        int pageSize =10;
//        List<Question> result = (List<Question>)
//                dao.getPaginatedContent(tableName,pageNum,pageSize);
//        if(result==null){
//            fail();
//        }else if(result.size()!=pageSize){
//            fail();
//        }else{
//            for(Question question : result){
//                System.out.println("QuestionID : "+question.getId());
//            }
//
//        }

    }

    @Test
    public void getPaginatedContent1() throws Exception {
//        String tableName = "Question";
//        OrderByPara para = OrderByPara.answerCount;
//        int pageNum=1;
//        int pageSize =10;
//        List<Question> result = (List<Question>)
//                dao.getPaginatedContent(tableName,pageNum,pageSize,para);
//        if(result==null){
//            fail();
//        }else if(result.size()!=pageSize){
//            fail();
//        }else{
//            for(Question question : result){
//                System.out.println("QuestionID : "+question.getId()
//                + "  "+para.toString() + question.getAnswerCount());
//            }
//
//        }
    }

    @Test
    public void getPaginatedContent2() throws Exception {
//        String tableName = "Question";
//        OrderByPara para = OrderByPara.answerCount;
//        OrderByMethod method = OrderByMethod.ASC;
//        int pageNum=3;
//        int pageSize =10;
//        List<Question> result = (List<Question>)
//                dao.getPaginatedContent(tableName,pageNum,pageSize,para,method);
//        if(result==null){
//            fail();
//        }else if(result.size()!=pageSize){
//            fail();
//        }else{
//            for(Question question : result){
//                System.out.println("QuestionID : "+question.getId()
//                        + "  "+para.toString() + question.getAnswerCount());
//            }
//
//        }
    }

}