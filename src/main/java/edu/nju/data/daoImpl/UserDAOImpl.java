package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.User;
import edu.nju.data.util.VerifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by ss14 on 2016/7/12.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @Autowired
    BaseDAO baseDAO;
    @PersistenceContext
    EntityManager em;

    private static String tableName = "User";

    @Override
    public boolean exists(String username) {
        Query query = em.createQuery( " from "+tableName+" where name = ?1 " );
        query.setParameter(1,username);
        User user = (User) query.getSingleResult();

        if (user!=null){
            return true;
        }

        return false;
    }

    @Override
    public boolean verify(String username, String password)
    {
        Query query = em.createQuery( "select password from "+tableName+" where name = ?1" );
        query.setParameter(1,username);
        String pw = (String) query.getSingleResult();
        if( pw.equals(password) ){
            return true;
        }
        return false;
    }

    @Override
    public VerifyResult login(String username, String password) {
        if(!exists(username)){
            return VerifyResult.INEXISTENCE;
        }else if(!verify(username,password)){
            return VerifyResult.INCORRECT;
        }
        return VerifyResult.SUCCESS;
    }

    @Override
    public User getUserByName(String username) {
        Query query = em.createQuery( " from user where name = ?1" );
        query.setParameter(1,username);
        return (User) query.getSingleResult();
    }


}
