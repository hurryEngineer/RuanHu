package edu.nju.data.util;

import java.util.List;

/**
 * Created by Dora on 2016/7/20.
 */
public class Pager<T> {

    /**
     * 每一页中的内容
     */
    private List<T> data;

    /**
     * 页号
     */
    private int page;

    /**
     * 每一页的大小
     */
    private int size;

    public Pager(List<T> data) {
        this.data = data;
        this.page = 1;
        this.size = 10;
    }

    public Pager(List<T> data, int page, int size) {
        this.data = data;
        this.page = page;
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "data=" + data +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
