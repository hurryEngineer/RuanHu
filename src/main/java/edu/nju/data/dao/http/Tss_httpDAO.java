package edu.nju.data.dao.http;

import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.Notification;
import edu.nju.data.util.Pager;

import java.io.IOException;

/**
 * Created by Dora on 2016/7/20.
 */
public interface Tss_httpDAO {

    /**
     * 通过id查询ppt
     * @param id
     * @return
     */
    public Document getDocumentById(long id) throws IOException;

    Document getDocumentByString(String s) throws IOException;

    /**
     * 通过关键字搜索ppt
     * @param keyword
     * @param page 页号
     * @param size 页大小
     * @return
     */
    public Pager<Document> searchDocumentsByKeyword(String keyword ,int page,int size) throws IOException;

    /**
     * 将消息通知给特定账户
     * @param notification
     * @return 是否成功
     */
    public boolean sendNotification(Notification notification) throws IOException;
}
