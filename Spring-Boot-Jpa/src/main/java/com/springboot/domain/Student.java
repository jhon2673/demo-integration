package com.springboot.domain;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 17:17
 * @Version 1.0
 */
@Entity
@Table(name = "uc_student")
public class Student implements Serializable {
    private static final long serialVersionUID = -673134183989321178L;

    @Id
    @Column(name = "user_id", unique = true, nullable = false, length = 16)
    private Long id;

    @Column(name = "student_no")
    private String sno;

    @Column(name = "student_name")
    private String name;

    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
