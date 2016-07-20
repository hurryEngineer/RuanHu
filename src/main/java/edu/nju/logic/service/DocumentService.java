package edu.nju.logic.service;

import edu.nju.data.entity.User;
import edu.nju.data.entity.api.Document;

import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
public interface DocumentService {
    /**
     * 根据id查找文档
     * @param id 文档id
     * @return {@link Document}
     */
    Document getDocById(long id);

    /**
     * 搜索文档
     * @param key 根据关键词查找文档
     * @return 查找到的文档列表
     */
    List<Document> searchDocuments(String key, int page);

    /**
     * 发送消息
     * @param userName 发送到的账号
     * @param message 要发送的消息
     */
    boolean sendMessage(String userName, String message, String userId);
}
