package edu.nju.logic.impl;

import edu.nju.data.entity.Answer;
import edu.nju.data.entity.Question;
import edu.nju.logic.service.TimeService;
import edu.nju.logic.vo.AnswerVO;
import edu.nju.logic.vo.QuestionVO;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * 将TimeStamp转化为字符串
 */
@Component
public class TimeImpl implements TimeService {
    @Override
    public String timeToString(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        Calendar now = Calendar.getInstance();
        long time = 0;
        if ((time = now.getTimeInMillis()-calendar.getTimeInMillis())<1800000)
            return time/60000+"分钟之前";
        String result = "";
        if (now.get(Calendar.YEAR)!=calendar.get(Calendar.YEAR)) result+=calendar.get(Calendar.YEAR)+"-";
        String[] day = {"今天 ","昨天 "};
        if (now.getTimeInMillis()-calendar.getTimeInMillis()>=86400000)
            result+=(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE)+" ";
        else
            result+=day[now.get(Calendar.DATE)-calendar.get(Calendar.DATE)];
        result+=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);
        return result;
    }

}
