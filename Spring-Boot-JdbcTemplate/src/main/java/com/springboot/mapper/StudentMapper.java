package com.springboot.mapper;

import com.springboot.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 17:21
 * @Version 1.0
 */
public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setSno(resultSet.getString("sno"));
        student.setName(resultSet.getString("sname"));
        student.setSex(resultSet.getString("ssex"));
        return student;
    }
}
