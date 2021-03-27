package com.springboot.service;

import com.springboot.domain.Student;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 14:45
 * @Version 1.0
 */
public interface StudentService {
    /**
     * 列出所有学生(分页)
     *
     * @param offset
     * @param pageSize
     * @return
     */
    List<Student> list(int offset, int pageSize);

    /**
     * 根据id获取学生
     *
     * @param id
     * @return
     */
    Student readById(long id);
}
