package edu.nju.data.dao.http;

import edu.nju.data.entity.api.WikiItem;
import edu.nju.data.util.Pager;

import java.io.IOException;

/**
 * Created by Dora on 2016/7/20.
 */
public interface Wiki_httpDAO {

    /**
     * 通过id查询一个wiki条目
     * @param id
     * @return
     */
    public WikiItem getWikiById(long id) throws IOException;

    /**
     * 通过关键字查询wiki条目
     * @param keyword
     * @param page 页号
     * @param size 页大小
     * @return
     */
    public Pager<WikiItem> searchWikiByKeyword(String keyword, int page, int size) throws IOException;


    /**
     * 接受一段文本,将与wiki匹配的词用span包起来,并添加链接
     * 关键字用span标注,href=”wiki url”
     * @param content 需要添加标注的文本
     * @return
     */
    public String addKeyMatch(String content) throws IOException;
}
