package com.example.dao;

import com.example.document.EsStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/10 9:58
 * @Version 1.0
 */
@Mapper
public interface EsStudentDao {
    List<EsStudent> getAllEsProductList(@Param("id") Long id);
}
