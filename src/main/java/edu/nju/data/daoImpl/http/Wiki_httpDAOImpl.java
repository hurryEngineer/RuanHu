package edu.nju.data.daoImpl.http;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.dao.http.Wiki_httpDAO;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.HttpRequest;
import edu.nju.data.util.Pager;
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


    String url = "";

    @Override
    public WikiItem getWikiById(long id) throws IOException {
        String s = HttpRequest.sendGet(url);
        ObjectMapper mapper = new ObjectMapper();
        WikiItem item = mapper.readValue(s, WikiItem.class);
        return item;
    }

    @Override
    public WikiItem getWikiByString(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        WikiItem item = mapper.readValue( mapper.readTree(s).get("data").toString(), WikiItem.class);
        return item;
    }

    @Override
    public Pager<WikiItem> searchWikiByKeyword(String keyword, int page, int size) throws IOException {
        String s = HttpRequest.sendGet(url);
        List<WikiItem> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        list = mapper.readValue(s, new TypeReference<List<WikiItem>>() {});
        Pager<WikiItem> pager = new Pager<WikiItem>(list);
        return pager;
    }

    @Override
    public String addKeyMatch(String content) throws IOException {
        String s = HttpRequest.sendGet(url);
        return s;
    }
}
