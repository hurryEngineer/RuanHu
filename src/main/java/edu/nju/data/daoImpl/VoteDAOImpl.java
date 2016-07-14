package edu.nju.data.daoImpl;

import edu.nju.data.dao.BaseDAO;
import edu.nju.data.dao.VoteDAO;
import edu.nju.data.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ss14 on 2016/7/14.
 */
@Repository
@Transactional
public class VoteDAOImpl implements VoteDAO {
    @Autowired
    BaseDAO baseDAO;

    private static String tableName = "Vote";

    @Override
    public void save(Vote vote) {

        baseDAO.insert(vote);

    }
}
