package com.springboot.service;

import com.springboot.bean.Student;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:22
 * @Version 1.0
 */
public interface StudentService {
    int add(Student student);

    int update(Student student);

    int deleteBySno(String sno);

    Student queryStudentBySno(String sno);
}
