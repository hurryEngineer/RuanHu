package edu.nju.data.daoImpl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.VoteDAO;
import edu.nju.data.entity.Vote;
import edu.nju.data.util.VoteType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/7/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RuanHuApplication.class)
@WebAppConfiguration
public class VoteDAOImplTest {


    @Autowired
    VoteDAO voteDAO;



    @Test
    public void vote() throws Exception {

        Long authorID = new Long (2);
        Long answerID = new Long (1);
        Vote vote = new Vote();
        vote.setAuthorId(authorID);
        vote.setAnswerId(answerID);
        vote.setVoteType(VoteType.up);

        voteDAO.vote(vote);

    }


    @Test
    public void save() throws Exception {
        Long authorID = new Long (2);
        Long answerID = new Long (1);
        Vote vote = new Vote();
        vote.setAuthorId(authorID);
        vote.setAnswerId(answerID);
        vote.setVoteType(VoteType.up);

        voteDAO.save(vote);

    }

    @Test
    public void cancel() throws Exception {
        Long authorID = new Long (1);
        Long answerID = new Long (1);
        Vote vote = new Vote();
        vote.setAuthorId(authorID);
        vote.setAnswerId(answerID);
        vote.setVoteType(VoteType.up);

        voteDAO.cancel(vote);


    }

}