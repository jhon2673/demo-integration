package com.springboot.dao.impl;

import com.springboot.bean.Student;
import com.springboot.dao.StudentDao;
import com.springboot.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 17:27
 * @Version 1.0
 */
@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao {
    private final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        String sql = "SELECT * FROM uc_student";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        String sql = "SELECT * FROM uc_student t WHERE t.student_no = ?";
        List<Student> studentList = this.jdbcTemplate.query(sql, new Object[]{sno}, new int[]{Types.VARCHAR}, new StudentMapper());
        logger.info("studentList:" + studentList);
        if (studentList != null && studentList.size() > 0) {
            return studentList.get(0);
        }
        return null;
    }

    @Override
    public int add(Student student) {
        String sql = "INSERT INTO uc_student(student_no, student_name, sex) VALUES(?, ?, ?)";
        return this.jdbcTemplate.update(sql, new Object[]{student.getSno(), student.getName(), student.getSex()});
    }

    @Override
    public int update(Student student) {
        String sql = "UPDATE uc_student t SET t.student_name = ?, t.sex = ? WHERE t.student_no = ?";
        return this.jdbcTemplate.update(sql, new Object[]{student.getName(), student.getSex(), student.getSno()});
    }

    @Override
    public int deleteBysno(String sno) {
        String sql = "DELETE uc_student t WHERE t.student_no = ?";
        return this.jdbcTemplate.update(sql, new Object[]{sno});
    }
}
