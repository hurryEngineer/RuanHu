package edu.nju.web.controller;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.User;
import edu.nju.data.util.VoteType;
import edu.nju.logic.service.AnswerService;
import edu.nju.logic.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/answer")
@SessionAttributes("user")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    /**
     * 将答案的内容临时保存在session里
     * @param questionId 答案对应的问题编号
     * @param markedText 答案临时保存的内容
     * @param session {@link HttpSession}
     */
    @RequestMapping("/tempSave")
    public void tempSave(@RequestParam("questionId") String questionId,
                         @RequestParam("markedText") String markedText, HttpSession session) {
        Answer answer = getTempAnswer(questionId, session);
        answer.setContent(markedText);
        ((Map<String,Answer>)session.getAttribute("tempAnswer")).put(questionId, answer);
    }

    /**
     * 获取保存在session里的answer<br>
     *     若answer里没有answer这个map，就新建一个
     *     若map里没有指定id的answer，则新建一个空的answer
     * @param questionId 回答的问题的id
     * @param session {@link HttpSession}
     * @return {@link Answer}
     */
    @RequestMapping("/getTempAnswer")
    public AnswerVO getTempAnswer(@RequestParam("questionId") String questionId, HttpSession session) {
        Object answer = session.getAttribute("tempAnswer");
        if (answer!=null) {
            Map<String, AnswerVO> answerMap =  (Map<String,AnswerVO>) answer;
            return answerMap.containsKey(questionId)? answerMap.get(questionId):new AnswerVO(new Answer());
        } else {
            Map<String, AnswerVO> answerMap = new HashMap<>();
            session.setAttribute("tempAnswer", answerMap);
            return new AnswerVO(new Answer());
        }
    }

    /**
     * 新建一个answer
     * @return 返回新建answer页面
     */
    @RequestMapping(value = "/newAnswer", method = RequestMethod.GET)
    @ResponseBody
    public String  newAnswer(){
        return "newAnswer";
    }

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
                              @RequestParam("markedText") String markedText, HttpSession session){
        User user = (User) session.getAttribute("user");
        return answerService.saveAnswer(Long.valueOf(questionId), user.getId(), markedText);
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

    @RequestMapping(value = "/upVote", method = RequestMethod.GET)
    @ResponseBody
    String upVote(@RequestParam("questionId") String questionId,
                  @RequestParam("answerId") String answerId,
                  @RequestParam("userId") String userId) {
        answerService.vote(questionId, answerId, userId, VoteType.up);
        return "success";
    }

    @RequestMapping(value = "/downVote", method = RequestMethod.GET)
    @ResponseBody
    String downVote(String questionId, String answerId, String userId) {
        answerService.vote(questionId, answerId, userId, VoteType.down);
        return "true";
    }

    @RequestMapping(value = "/upCancel")
    void upVoteCancel(String questionId, String answerId, String userId) {
        answerService.vote(questionId, answerId, userId, VoteType.up);
    }

    @RequestMapping(value = "/downCancel")
    void downVoteCancel(String questionId, String answerId, String userId) {
        answerService.vote(questionId, answerId, userId, VoteType.down);
    }

}
