package edu.nju.data.daoImpl.http;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.config.ApiConfig;
import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.HttpRequest;
import edu.nju.data.util.KeyMatch;
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
        String s = HttpRequest.sendGet(apiConfig.getWikiApiAddress()+"search?q="+keyword);
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
        KeyMatch km = new KeyMatch();
        km.setContent(content);
        String s = HttpRequest.sendPost(apiConfig.getWikiApiAddress()+"keymatch",km);
        return s;
    }
}
