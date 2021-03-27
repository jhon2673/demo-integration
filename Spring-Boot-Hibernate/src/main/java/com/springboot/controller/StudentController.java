package com.springboot.controller;

import com.springboot.domain.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 14:47
 * @Version 1.0
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Student> list(int offset, int pageSize) {
        List<Student> studentList = studentService.list(offset, pageSize);
        return studentList;
    }

    @RequestMapping("/readById")
    @ResponseBody
    public Student readById(long id) {
        Student studen = studentService.readById(id);
        return studen;
    }
}
