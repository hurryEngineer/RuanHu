package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.BaseDAO;
import edu.nju.data.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
public class BaseDAOImplTest {
    @Autowired
    BaseDAO baseDAO;
    @PersistenceContext
    EntityManager em;

    @Test
    public void insert() throws Exception {

        User user = new User();
        String name= "ss14";
        String pw="123";
        user.setUserName(name);
        user.setPassword(pw);
        baseDAO.insert(user);

        Query query = em.createQuery("from User where userName = ?1");
        query.setParameter(1,name);
        List<User> loadUser = (List<User>) query.getResultList();
        if(loadUser.size()==0){
            fail( "insert()------------");
        }else {
            System.out.println("name : "+loadUser.get(0).getUserName()+
                    " pw : "+loadUser.get(0).getPassword());
        }


    }

    @Test
    public void delete() throws Exception {
        long id =2;
        User temp = (User) baseDAO.load(User.class,id);
        baseDAO.delete(User.class,id);
        if(baseDAO.load(User.class,id)!=null){
            fail();
        }else{
            baseDAO.insert(temp);
        }

    }

    @Test
    public void update() throws Exception {
        User user = new User();
        long id =2;
        String name= "ss14";
        String pw="123456";
        user.setId(id);
        user.setUserName(name);
        user.setPassword(pw);
        baseDAO.update(user);
    }

    @Test
    public void load() throws Exception {
        long id =1;
        String name = "ch";
        User user = (User) baseDAO.load(User.class , id);
        if(!name.equals(user.getUserName())){
            fail();
        }else{
            System.out.println("name : "+user.getUserName()+
                    " pw : "+user.getPassword());
        }

    }

}