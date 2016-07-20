package edu.nju.data.daoImpl.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.dao.http.Tss_httpDAO;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.Notification;
import edu.nju.data.util.HttpRequest;
import edu.nju.data.util.Pager;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/7/20.
 */
@Repository
public class Tss_httpDAOImpl implements Tss_httpDAO {

    String url = "";


    @Override
    public Document getDocumentById(long id) throws IOException{

        String s = HttpRequest.sendGet(url);
        ObjectMapper mapper = new ObjectMapper();
        Document document = mapper.readValue(s, Document.class);
        return document;
    }

    @Override
    public Pager<Document> searchDocumentsByKeyword(String keyword, int page, int size) throws IOException{

        String s = HttpRequest.sendGet(url);
        List<Document> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        list = mapper.readValue(s, new TypeReference<List<Document>>() {});
        Pager<Document> pager = new Pager<Document>(list);

        return pager;
    }

    @Override
    public boolean sendNotification(Notification notification) throws IOException {
        String s = HttpRequest.sendPost(url,notification);
        if(s != null)
            return true;
        return false;
    }
}
