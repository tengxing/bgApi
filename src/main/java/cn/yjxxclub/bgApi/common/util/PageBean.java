package cn.yjxxclub.bgApi.common.util;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-29
 * Time: 上午9:04
 * Describe: 分页工具类
 */
public class PageBean {
    private int page; //页数
    private int pageSize; // 页数大小
    private int start;  //


    public PageBean(int page, int pageSize) {
        super();
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (page-1)*pageSize;
    }
}
