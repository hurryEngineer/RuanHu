package edu.nju.logic.impl;

import edu.nju.RuanHuApplication;
import edu.nju.data.dao.UserDAO;
import edu.nju.data.entity.Message;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.vo.MessageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2016/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = RuanHuApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
@Rollback
@Transactional
public class TransferImplTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TransferService transferService;

    @Test
    public void transferMessage() throws Exception {
        List<Message> messages = userDAO.getAllMessage(new Long(3));
        List<MessageVO> messageVOs = transferService.transferMessage(messages);
        for (MessageVO messageVO: messageVOs) {
            if (messageVO.getId()==37){
                System.out.println(messageVO.getMesgType());
                System.out.println(messageVO.getSourceId());
            }
        }
    }

}