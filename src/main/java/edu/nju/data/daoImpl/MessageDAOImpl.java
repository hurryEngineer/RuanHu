package edu.nju.data.daoImpl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.MessageDAO;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;
import edu.nju.data.util.Mesg_Helper.MesFactoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Created by ss14 on 2016/7/21.
 */

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    BaseDAO baseDAO;
    @Autowired
    MesFactoryInterface mesFactory;

    @PersistenceContext
    EntityManager em;




    @Override
    public void save(Message mes) {

        mes.setId(null);
        baseDAO.insert(mes);

    }

    @Override
    public long save_id(Message mes) {

            mes.setId(null);
            em.persist(mes);
            em.flush();
            return mes.getId();
    }

    @Override
    public Message save_Message(Message mes) {

            mes.setId(null);
            em.persist(mes);
            em.flush();
            return mes;

    }

    @Override
    public boolean markChecked(Message mes) {

        Message loaded = em.find(Message.class , mes.getId());

        if(loaded != null){
            loaded.setChecked((short) 1);
            em.flush();
            return true;
        }

        return false;
    }

    @Override
    public boolean markChecked(Long mesID) {

        Message loaded = em.find(Message.class ,mesID);

        if(loaded != null){
            loaded.setChecked((short) 1);
            em.flush();
            return true;
        }

        return false;
    }

    @Override
    public void deleteByMesID(Long mesID) {

        baseDAO.delete(Message.class , mesID);

    }



    @Override
    public void sendMessage(MesType type, Long scrId, User sender, User receiver) {

        Message message = mesFactory.createMessage(type,scrId,sender,receiver);

        Query query = em.createQuery(" from Message m where m.mesgType = ?1 and m.sourceId = ?2 and m.sender.id= ?3 and m.receiver.id = ?4 ");
        query.setParameter(1,type);
        query.setParameter(2,scrId);
        query.setParameter(3,sender.getId());
        query.setParameter(4,receiver.getId());
        List<Message> result = query.getResultList();
        if(result==null){
            save(message);
        }else if(result.size()==0){
            save(message);
        }else{
            System.out.println("Duplicate!!!");
        }


    }
}
