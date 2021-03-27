package com.example.repository;

import com.example.document.Activity;
import com.example.document.EsStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/25 11:12
 * @Version 1.0
 */
public interface ActivityRepository extends ElasticsearchRepository<Activity, Long> {

    Page<Activity> findByActivityName(String activityName, Pageable page);
}
