package edu.nju.logic.impl;

import edu.nju.data.dao.VoteDAO;
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

    @Override
    public QuestionVO transferQuestion(Question question, long userId) {
        QuestionVO questionVO = new QuestionVO(question);
        if (question.getCreatedAt()!=null)
            questionVO.setCreateAtForView(timeService.timeToString(question.getCreatedAt()));
        if (question.getLastUpdatedAt()!=null)
            questionVO.setUpdateAtForView(timeService.timeToString(question.getLastUpdatedAt()));
        int vote = 0;
        if (userId>=0) {
            if (voteDAO.hasVoteQuestion(userId,question.getId(), VoteType.up)) {
                vote = 1;
            } else if (voteDAO.hasVoteQuestion(userId, question.getId(), VoteType.down)) {
                vote = -1;
            }
        }
        questionVO.setVote(vote);
        WikiItem item = new WikiItem();
        item.setId(1);
        item.setTitle("唐诗宋词原理分享");
        item.setSummary("v2.0本意是进行数据上的优化。但是由于数据量很大，存储方式由原先的写在代码中，变为在文件中，因此不得不采用异步方式，这样原先的代码绝大部分都不能使用了。\\n\\n#原理分享\\n\\n主要进行了以下几个步骤的工作：\\n+ 从网络上抓取大量诗词数据\\n+ 按格式将诗词分类\\n+ 对诗词正文进行分词操作\\n+ 统计各词出现的频率\\n+ 统计五言、七言诗句的句型，并将高频句型作为模板保存。\\n+ 根据参数或者随机挑选模板，然后使用词库渲染之。\\n\\n##1、 抓取诗词\\n首先选定了 http://so.gushiwen.org/ 这个网站作为抓取的目标");
        List<WikiItem> list = new ArrayList<>();
        list.add(item);
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
        int vote = 0;
        if (userId>=0) {
            if (voteDAO.hasVoteAnswer(userId, answer.getId(), VoteType.up)) {
                vote = 1;
            } else if (voteDAO.hasVoteAnswer(userId, answer.getId(), VoteType.down)) {
                vote = -1;
            }
        }
        answerVO.setVote(vote);
        return answerVO;
    }
}
