package edu.nju.web.controller.json;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.User;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.AnswerService;

@Controller
@RequestMapping("/json/answer")
@SessionAttributes("user")
public class AnswerJsonController {

    @Autowired
    private AnswerService answerService;

    /**
     * 保存一个answer
     * @param questionId answer对应的问题id
     * @param markedText answer的内容
     * @param session {@link HttpSession}
     * @return 是否保存成功布尔值
     */
    @RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
    @ResponseBody
    public boolean saveAnswer(@RequestParam("questionId") String questionId,
                              @RequestParam("markedText") String markedText,
                              @RequestParam(value="wikis",defaultValue="")List<Long> wikiIds,
                              @RequestParam(value="docs",defaultValue="")List<Long> docIds, HttpSession session){
        User user = (User) session.getAttribute("user");
        return answerService.saveAnswer(Long.valueOf(questionId), user.getId(), markedText, wikiIds, docIds);
    }

    /**
     * 根据回答id获取一个回答的内容
     * @param answerId 回答id
     * @return 回答的内容
     */
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public Answer getAnswer(@RequestParam("id")String answerId) {
        return answerService.getAnswer(Long.valueOf(answerId));
    }

    /**
     * 将问题标记为正确答案
     * @param answerId 要标记的answer id
     * @param questionId answer对应的问题id
     * @param session {@link HttpSession}
     * @return 如果是提问者本人标记，则标记成功返回true;否则返回false
     */
    @RequestMapping(value = "/markAsSolution",method = RequestMethod.GET)
    @ResponseBody
    public boolean markAsSolution(@RequestParam("answerId") String answerId,
                                  @RequestParam("questionId") String questionId, HttpSession session){
        User user = (User) session.getAttribute("user");
        return answerService.markAsSolution(user, Long.valueOf(questionId), Long.valueOf(answerId));
    }

    /**
     * 投票：赞同票
     * @param questionId 问题id
     * @param answerId 回答id
     * @param userId 用户id
     * @return 投票后的总票数
     */
    @RequestMapping(value = "/upVote", method = RequestMethod.GET)
    @ResponseBody
    int upVote(@RequestParam("questionId") String questionId,
                  @RequestParam("answerId") String answerId,
                  @RequestParam("userId") String userId) {
        return answerService.vote(questionId, answerId, userId, VoteType.up);
    }

    /**
     * 投票：反对票
     * @param questionId 问题id
     * @param answerId 回答id
     * @param userId 用户id
     * @return 投票后的总票数
     */
    @RequestMapping(value = "/downVote", method = RequestMethod.GET)
    @ResponseBody
    int downVote(String questionId, String answerId, String userId) {
        return answerService.vote(questionId, answerId, userId, VoteType.down);
    }


}
