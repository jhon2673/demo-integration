package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:28
 * @Version 1.0
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/queryStudentBySno", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }

    @RequestMapping(value = "/queryAllStudents", method = RequestMethod.GET)
    public List<Student> queryAllStudents() {
        PageHelper.startPage(2, 5);
        List<Student> list = studentService.queryAllStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }
}
