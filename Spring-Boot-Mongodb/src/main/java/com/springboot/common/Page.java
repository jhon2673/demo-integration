package com.springboot.common;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/24 16:17
 * @Version 1.0
 */
public class Page {

    private int pageNumber;

    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
