package edu.nju.data.daoImpl.http;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.config.ApiConfig;
import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.HttpRequest;
import edu.nju.data.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dora on 2016/7/20.
 */
@Repository
public class Wiki_httpDAOImpl implements Wiki_httpDAO {

    @Autowired
    ApiConfig apiConfig;

//    String url = "";

//    String s = "{\"exist\":1,\"data\":{\"title\":\"唐诗宋词原理分享\",\"categories\":[\"他就是爱吃火锅\"],\"currVersionString\":\"0.1\",\"editor\":\"dzm14\",\"visits\":6,\"date\":\"2016-07-18 09:19:04\",\"tags\":[\"Andorra\"],\"content\":\"v2.0本意是进行数据上的优化。但是由于数据量很大，存储方式由原先的写在代码中，变为在文件中，因此不得不采用异步方式，这样原先的代码绝大部分都不能使用了。\\n\\n#原理分享\\n\\n主要进行了以下几个步骤的工作：\\n\"}}\n";

    @Override
    public WikiItem getWikiById(long id) throws IOException {
        String s = HttpRequest.sendGet(apiConfig.getWikiApiAddress()+"entry/"+id);
//        ObjectMapper mapper = new ObjectMapper();
//        WikiItem item = mapper.readValue(s, WikiItem.class);
        WikiItem item = getWikiByString(s);
        return item;
    }

    private WikiItem getWikiByString(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        WikiItem item = null;
        if(s!=null&&!s.equals(""))
            item = mapper.readValue( s, WikiItem.class);
        return item;
    }

    @Override
    public Pager<WikiItem> searchWikiByKeyword(String keyword, int page, int size) throws IOException {
        String s = HttpRequest.sendGet(apiConfig.getWikiApiAddress()+"entry/search?q="+keyword);
        List<WikiItem> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        list = mapper.readValue(s, new TypeReference<List<WikiItem>>() {});
        Pager<WikiItem> pager = new Pager<WikiItem>(list);

//        ObjectMapper mapper = new ObjectMapper();
//        List<WikiItem> list = new ArrayList<>();
//        WikiItem wi = getWikiByString(s);
//        wi.setId(1);
//        list.add(wi);
//        WikiItem wi2 = getWikiByString(s);
//        wi2.setId(2);
//        list.add(wi2);
//        WikiItem wi3 = getWikiByString(s);
//        wi3.setId(3);
//        list.add(wi3);
//        Pager<WikiItem> pager = new Pager<WikiItem>(list);

        return pager;
    }

    @Override
    public String addKeyMatch(String content) throws IOException {
        String s = HttpRequest.sendGet(apiConfig.getWikiApiAddress()+"keymatch");
        return s;
    }
}
