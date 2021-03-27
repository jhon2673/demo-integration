package com.springboot.dao;

import com.springboot.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 17:25
 * @Version 1.0
 */
public interface StudentDao {
    /**
     * 获取所有学生
     *
     * @return
     */
    List<Map<String, Object>> queryStudentsListMap();

    /**
     * 根据学号获取学生
     *
     * @param sno
     * @return
     */
    Student queryStudentBySno(String sno);

    /**
     * 添加一个学生
     *
     * @param student
     * @return
     */
    int add(Student student);

    /**
     * 更新学生
     *
     * @param student
     * @return
     */
    int update(Student student);

    /**
     * 根据学号删除学生
     *
     * @param sno
     * @return
     */
    int deleteBysno(String sno);
}
