package com.springboot.repository;

import com.springboot.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 10:48
 * @Version 1.0
 */
@Repository
public interface StudedntDao extends JpaRepository<Student, Long> {
}
