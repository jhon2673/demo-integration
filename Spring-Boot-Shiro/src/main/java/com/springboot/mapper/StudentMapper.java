package com.springboot.mapper;

import com.springboot.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:01
 * @Version 1.0
 */
@Component
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO uc_student(student_no, student_name, sex) VALUES(#{sno}, #{name}, #{ssex})")
    int add(Student student);

    @Update("UPDATE uc_student t SET t.student_name = #{name}, t.sex = #{ssex} WHERE t.student_no = #{sno}")
    int update(Student student);

    @Delete("DELETE uc_student t WHERE t.student_no = #{sno}")
    int deleteBySno(String sno);

    @Select("SELECT * FROM uc_student t WHERE t.student_no = #{sno}")
    @Results(id = "student", value = {
            @Result(property = "sno", column = "student_no", javaType = String.class),
            @Result(property = "name", column = "student_name", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class)
    })
    Student queryStudentBySno(String sno);

    @Select("SELECT * FROM uc_student")
    @Results(id = "studentList", value = {
            @Result(property = "sno", column = "student_no", javaType = String.class),
            @Result(property = "name", column = "student_name", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class)
    })
    List<Student> queryAllStudents();
}
