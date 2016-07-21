package edu.nju.data.daoImpl;

import edu.nju.data.dao.InviteDAO;
import edu.nju.data.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ss14 on 2016/7/21.
 */
@Repository
public class InviteDAOImpl implements InviteDAO {

    @Override
    public void invite(Long srcId, User sender, List<User> receivers) {

    }
}
