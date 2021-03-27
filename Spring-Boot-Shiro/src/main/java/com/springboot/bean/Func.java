package com.springboot.bean;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/11 20:01
 * @Version 1.0
 */
public class Func implements Serializable {

    private static final long serialVersionUID = -4048475804212570672L;
    private Integer id;
    private String name;
    private String src;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Func{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
