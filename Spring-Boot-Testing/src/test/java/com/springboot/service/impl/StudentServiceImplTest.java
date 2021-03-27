package com.springboot.service.impl;

import com.springboot.bean.Student;
import com.springboot.service.StudentService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/5 16:14
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        logger.info("setUp");
    }

    @After
    public void tearDown() throws Exception {
        logger.info("tearDown");
    }

    @Test
    public void add() {
    }

    @Test
    public void queryStudentBySno() {
        Student student = this.studentService.queryStudentBySno("cs001");
        Assert.assertEquals("学生名为：测试学生001", "测试学生001", student.getName());
    }
}