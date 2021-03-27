package com.springboot.mapper;

import com.springboot.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:01
 * @Version 1.0
 */
@CacheConfig(cacheNames = "student")
@Mapper
public interface StudentMapper {
    @CachePut(key = "#p0.sno")
    @Update("UPDATE uc_student t SET t.student_name = #{name}, t.sex = #{ssex} WHERE t.student_no = #{sno}")
    int update(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    @Delete("DELETE uc_student t WHERE t.student_no = #{sno}")
    int deleteBySno(String sno);

    @Cacheable(key = "#p0")
    @Select("SELECT * FROM uc_student t WHERE t.student_no = #{sno}")
    @Results(id = "student", value = {
            @Result(property = "sno", column = "student_no", javaType = String.class),
            @Result(property = "name", column = "student_name", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class)
    })
    Student queryStudentBySno(String sno);
}
