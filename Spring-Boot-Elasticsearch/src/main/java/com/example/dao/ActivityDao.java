package com.example.dao;

import com.example.document.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/25 10:46
 * @Version 1.0
 */
@Mapper
public interface ActivityDao {

    List<Activity> list();
}
