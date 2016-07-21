package edu.nju.logic.service;

import edu.nju.data.entity.api.Document;
import edu.nju.data.entity.api.WikiItem;

import java.util.List;

/**
 * Created by cuihao on 2016/7/20.
 */
public interface WikiService {
    /**
     * 获取wiki
     * @param id wiki id
     * @return {@link WikiItem}
     */
    WikiItem getWikiById(long id);

    /**
     * 搜索wiki
     * @param key 搜索关键词
     * @return 满足关键词的wiki列表
     */
    List<WikiItem> searchWikis(String key, int page);

    /**
     * 把一段文字中的wiki关键字加上span
     * @param content 要处理的一段文字
     * @return 处理好后的文字
     */
    String keyMatch(String content);

    /**
     * 根据wikiID获取与之相关的问题ID
     */
    List<WikiItem> getRelatedWikis(long questionId);


    /**
     * 根据wikiID获取与之相关的文件ID
     */
    List<Document> getRelatedDocuments(long questionId);

    /**
     * 插入与某一个问题相关的一系列wiki条目
     */
    void insertQuestion(long questionID , List wikiIDs);

    /**
     * 插入与某一个回答相关的一系列wiki条目
     */
    void insertAnswer(long answerID , List wikiIDs);
}
