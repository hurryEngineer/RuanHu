package edu.nju.logic.impl;

import edu.nju.data.dao.http.Tss_httpDAO;
import edu.nju.data.entity.api.CommonUser;
import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.Notification;
import edu.nju.data.util.Pager;
import edu.nju.data.util.Source;
import edu.nju.logic.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
@Component
public class DocumentImpl implements DocumentService {

    @Autowired
    private Tss_httpDAO tss_httpDAO;

    @Override
    public Document getDocById(long id) {
        Document document = null;
        try {
            document = tss_httpDAO.getDocumentById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public List<Document> searchDocuments(String key, int page) {
        Pager<Document> pager = null;
        try {
            pager = tss_httpDAO.searchDocumentsByKeyword(key,page,10);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Document> documents = new ArrayList<>();
        if (pager!=null) {
            documents = pager.getData();
        }
        return documents;
    }

    @Override
    public boolean sendMessage(String userName, String message, String userId) {
        Notification notification = new Notification();
        CommonUser commonUser = new CommonUser();
        commonUser.setId(Long.valueOf(userId));
        commonUser.setUserName(userName);
        notification.setMessage(message);
        notification.setUser(commonUser);
        notification.setSource(Source.ruanhu);
        try {
            return tss_httpDAO.sendNotification(notification);
        } catch (IOException e) {
            return false;
        }
    }
}
