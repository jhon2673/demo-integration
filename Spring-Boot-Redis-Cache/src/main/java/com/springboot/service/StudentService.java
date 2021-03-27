package com.springboot.service;

import com.springboot.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/5 13:34
 * @Version 1.0
 */
public interface StudentService {

    Student update(Student student);

    void deleteStudentBySno(String sno);

    Student queryStudentBySno(String sno);
}
