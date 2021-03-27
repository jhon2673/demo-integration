package com.example.repository;


import com.example.document.EsStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/9 20:47
 * @Version 1.0
 */
public interface EsStudentRepository extends ElasticsearchRepository<EsStudent, Long> {

    /**
     * 学生搜索
     *
     * @param sno
     * @param name
     * @param page
     * @return
     */
    Page<EsStudent> findBySnoOrName(String sno, String name, Pageable page);
}
