package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.DocumentDAO;
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
 * Created by ss14 on 2016/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
@Rollback
public class DocumentDAOImplTest {
    @Autowired
    DocumentDAO documentDAO;
    @Test
    public void getRelatedWikis() throws Exception {
        long docuID = 4;
        List result = documentDAO.getRelatedWikis(docuID);
        if(result==null){
            fail();
        }else if (result.size()==0){
            fail();
        }else{
            System.out.println("quesID  :");
            for(int i=0;i<result.size(); i++){
                System.out.print(result.get(i)+" ");
            }
            System.out.print("\n");
        }
    }

    @Test
    public void getRelatedQuestions() throws Exception {
        long docuID = 4;
        List result = documentDAO.getRelatedQuestions(docuID);
        if(result==null){
            fail();
        }else if (result.size()==0){
            fail();
        }else{
            System.out.println("quesID  :");
            for(int i=0;i<result.size(); i++){
                System.out.print(result.get(i)+" ");
            }
            System.out.print("\n");
        }
    }

}