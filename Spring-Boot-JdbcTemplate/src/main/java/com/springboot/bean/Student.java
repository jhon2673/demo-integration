package com.springboot.bean;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 17:17
 * @Version 1.0
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -6240769402110284535L;

    private String sno;
    private String name;
    private String sex;

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
                "sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
