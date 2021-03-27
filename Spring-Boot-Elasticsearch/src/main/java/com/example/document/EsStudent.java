package com.example.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/9 20:16
 * @Version 1.0
 */
@Document(indexName = "index_student", type = "uc_student")
public class EsStudent implements Serializable {
    private static final long serialVersionUID = 5957750101801793001L;

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String sno;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Keyword)
    private Integer sex;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
