package edu.nju.data.daoImpl;

import edu.nju.data.dao.InviteDAO;
import edu.nju.data.dao.MessageDAO;
import edu.nju.data.entity.Message;
import edu.nju.data.entity.User;
import edu.nju.data.util.MesType;
import edu.nju.data.util.Mesg_Helper.MesFactoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ss14 on 2016/7/21.
 */
@Repository
public class InviteDAOImpl implements InviteDAO {
    @Autowired
    MessageDAO messageDAO ;
    @Autowired
    MesFactoryInterface mesFactory;

    @Override
    public void invite(Long srcId, User sender, List<User> receivers) {

       List<Message> messages = mesFactory.createMessage(MesType.invite , srcId , sender ,receivers);

        for(Message message : messages){

            messageDAO.save(message);

        }

    }
}
