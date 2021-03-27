package com.springboot.controller;

import com.springboot.bean.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 18:50
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/queryAllStudent")
    public List<Map<String, Object>> queryAllStudent() {
        return this.studentService.queryStudentsListMap();
    }

    @RequestMapping("/queryStudentBySno")
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }

    @RequestMapping("/saveStudent")
    public int saveStudent(String sno, String name, String sex) {
        Student student = new Student();
        student.setSno(sno);
        student.setName(name);
        student.setSex(sex);
        return this.studentService.add(student);
    }

    @RequestMapping("/updateStudent")
    public int updateStudent() {
        Student student = new Student();
        student.setSno("111");
        student.setName("test");
        student.setSex("1");
        return this.studentService.update(student);
    }

    @RequestMapping("/deleteStudentBySno")
    public int deleteStudentBySno(String sno) {
        return this.studentService.deleteBysno(sno);
    }
}
