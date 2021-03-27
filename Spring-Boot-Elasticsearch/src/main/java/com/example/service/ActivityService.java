package com.example.service;

import com.example.document.Activity;
import com.example.document.EsStudent;
import org.springframework.data.domain.Page;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/25 11:15
 * @Version 1.0
 */
public interface ActivityService {

    /**
     * 导入所有活动数据到ES
     *
     * @return
     */
    int importAll();

    /**
     * 搜索
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Activity> search(String keyword, Integer pageNum, Integer pageSize);
}
