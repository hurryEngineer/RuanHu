package edu.nju.data.daoImpl.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.data.config.ApiConfig;
import edu.nju.data.dao.http.Tss_httpDAO;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.Notification;
import edu.nju.data.util.HttpRequest;
import edu.nju.data.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/7/20.
 */
@Repository
public class Tss_httpDAOImpl implements Tss_httpDAO {

    @Autowired
    ApiConfig apiConfig;


    String s = "{\"id\":1,\"icon\":\"http://www.freeiconspng.com/uploads/powerpoint-icon--office-2011-iconset--hamza-saleem-11.png\",\"url\":\"c://File/first.ppt\",\"title\":\"数据库设计.ppt\"}";
    String str = "[{\"id\":16072000000,\"url\":\"c://File/first.ppt\",\"title\":\"first.ppt\",\"icon\":\"http://www.freeiconspng.com/uploads/powerpoint-icon--office-2011-iconset--hamza-saleem-11.png\"},{\"id\":16072000001,\"url\":\"c://File/second.ppt\",\"title\":\"second.ppt\",\"icon\":\"http://www.freeiconspng.com/uploads/powerpoint-icon--office-2011-iconset--hamza-saleem-11.png\"}]";


    @Override
    public Document getDocumentById(long id) throws IOException{
        String s = HttpRequest.sendGet(apiConfig.getTssApiAddress()+"ppt?id="+id);
        return getDocumentByString(s);
    }

    private Document getDocumentByString(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Document document = mapper.readValue(s, Document.class);
        return document;
    }

    @Override
    public Pager<Document> searchDocumentsByKeyword(String keyword, int page, int size) throws IOException{

        String s = HttpRequest.sendGet(apiConfig.getTssApiAddress()+"ppt/search?key="+keyword);
        List<Document> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        list = mapper.readValue(s, new TypeReference<List<Document>>() {});
        Pager<Document> pager = new Pager<Document>(list);


        return pager;
    }

    @Override
    public boolean sendNotification(Notification notification) throws IOException {
        String s = HttpRequest.sendPost(apiConfig.getTssApiAddress(),notification);
        if(s != null)
            return true;
        return false;
    }
}
