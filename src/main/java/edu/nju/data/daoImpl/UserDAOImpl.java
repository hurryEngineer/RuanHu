package edu.nju.data.daoImpl;

import edu.nju.common.jgravatar.Gravatar;
import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.CommonParas;
import edu.nju.data.util.HQL_Helper.Impl.QueryHqlMaker;
import edu.nju.data.util.VerifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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
    public void save(User user) {

        if(user.getPhotoUri()==null) {
            Gravatar g = new Gravatar();
            g.setSize(CommonParas.PhotoSize);
            user.setPhotoUri(g.getUrl(user.getUserName() + user.getPassword()));
        }else if(user.getPhotoUri().length()<=1){
            Gravatar g = new Gravatar();
            g.setSize(CommonParas.PhotoSize);
            user.setPhotoUri(g.getUrl(user.getUserName() + user.getPassword()));
        }

        user.setId(null);
        baseDAO.insert(user);
    }

    @Override
    public boolean exists(String username) {
        Query query = em.createQuery( " from User where userName = ?1 " );
        query.setParameter(1,username);
        List<User> users = query.getResultList();

        if (users.size()>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean verify(String username, String password)
    {
        Query query = em.createQuery( "select password from User where userName = ?1" );
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
        Query query = em.createQuery( " from User where userName = ?1 " );
        query.setParameter(1,username);
        return (User) query.getSingleResult();
    }

    @Override
    public User getUserByID(Long id) {
        return (User) baseDAO.load(User.class , id );
    }

    @Override
    public void update(User user) {

        baseDAO.update(user);

    }

    @Override
    public List<User> search(String partName)
    {
        Query query = em.createQuery(" from User u where u.userName like :partName ");
        query.setParameter( "partName" , "%" +partName+"%");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<Message> getAllMessage(Long userID) {

        Query query = em.createQuery(" from Message m where m.receiver.id = ?1 ");
        query.setParameter(1,userID);
        List<Message> messages = query.getResultList();
        return messages;

    }

    @Override
    public long getMessageCount(Long userID) {
        Query query = em.createQuery("select count(m) from Message m where m.receiver.id = ?1 ");
        query.setParameter(1,userID);
        Long result  = (Long) query.getSingleResult();
        return result;
    }


}
