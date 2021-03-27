package com.example.service;

import com.example.document.EsStudent;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/9 20:54
 * @Version 1.0
 */
public interface EsStudentService {
    /**
     * 从数据库中导入所有学生到ES
     */
    int importAll();

    /**
     * 根据id删除学生
     */
    void delete(Long id);

    /**
     * 根据id创建学生
     */
    EsStudent create(Long id);

    /**
     * 批量删除学生
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     */
    Page<EsStudent> search(String keyword, Integer pageNum, Integer pageSize);
}
