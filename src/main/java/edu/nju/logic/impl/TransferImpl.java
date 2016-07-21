package edu.nju.logic.impl;

import edu.nju.data.dao.VoteDAO;
import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.service.TransferService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.aspectj.weaver.ast.ITestVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Component
public class TransferImpl implements TransferService {

    @Autowired
    private TimeService timeService;

    @Autowired
    private VoteDAO voteDAO;

    @Autowired
    private Wiki_httpDAO wiki_httpDAO;

    @Override
    public QuestionVO transferQuestion(Question question, long userId) {
        QuestionVO questionVO = new QuestionVO(question);
        if (question.getCreatedAt()!=null)
            questionVO.setCreateAtForView(timeService.timeToString(question.getCreatedAt()));
        if (question.getLastUpdatedAt()!=null)
            questionVO.setUpdateAtForView(timeService.timeToString(question.getLastUpdatedAt()));
        questionVO.setVote(voteDAO.hasVoteQuestion(userId, question.getId()));

        String s = "{\"exist\":1,\"data\":{\"title\":\"唐诗宋词原理分享\",\"categories\":[\"他就是爱吃火锅\"],\"currVersionString\":\"0.1\",\"editor\":\"dzm14\",\"visits\":6,\"date\":\"2016-07-18 09:19:04\",\"tags\":[\"Andorra\"],\"content\":\"v2.0本意是进行数据上的优化。但是由于数据量很大，存储方式由原先的写在代码中，变为在文件中，因此不得不采用异步方式，这样原先的代码绝大部分都不能使用了。\\n\\n#原理分享\\n\\n主要进行了以下几个步骤的工作：\\n\"}}\n";
        WikiItem item = null;
        List<WikiItem> list = new ArrayList<>();
        try {
            item = wiki_httpDAO.getWikiByString(s);
            item.setId(1);
            list.add(item);
            item.setId(2);
            list.add(item);
            item.setId(3);
            list.add(item);
        } catch (IOException e) {
            e.printStackTrace();
        }
        questionVO.setWikiItems(list);
        return questionVO;
    }

    @Override
    public AnswerVO transferAnswer(Answer answer, long userId) {
        AnswerVO answerVO = new AnswerVO(answer);
        if (answer.getCreatedAt()!=null)
            answerVO.setCreateAtForView(timeService.timeToString(answer.getCreatedAt()));
        if (answer.getLastUpdatedAt()!=null)
            answerVO.setUpdateAtForView(timeService.timeToString(answer.getLastUpdatedAt()));
        answerVO.setIsVote(voteDAO.hasVoteAnswer(userId, answer.getId()));
        return answerVO;
    }
}
