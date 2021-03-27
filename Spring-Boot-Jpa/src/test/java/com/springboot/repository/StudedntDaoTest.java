package com.springboot.repository;

import com.springboot.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 10:57
 * @Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudedntDaoTest {

    @Autowired
    private StudedntDao studedntDao;


    @Test
    public void testQuery() {
        List<Student> studentList = studedntDao.findAll();
//        Assert.assertTrue();
        log.debug("【studentList】= {}", studentList);
    }
}