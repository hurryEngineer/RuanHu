package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.WikiDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
public class WikiDAOImplTest {
    @Autowired
    WikiDAO wikiDAO;


    @Test
    public void getRelatedQuestions() throws Exception {
        long wikiID = 1;
        List result = wikiDAO.getRelatedQuestions(wikiID);
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
    public void getRelatedDocuments() throws Exception {
        long wikiID = 1;
        List result = wikiDAO.getRelatedDocuments(wikiID);
        if(result==null){
            fail();
        }else if (result.size()==0){
            fail();
        }else{
            System.out.println("docuID  :");
            for(int i=0;i<result.size(); i++){
                System.out.print(result.get(i)+" ");
            }
            System.out.print("\n");
        }
    }

}