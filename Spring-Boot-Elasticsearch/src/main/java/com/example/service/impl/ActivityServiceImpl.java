package com.example.service.impl;

import com.example.dao.ActivityDao;
import com.example.document.Activity;
import com.example.document.EsStudent;
import com.example.repository.ActivityRepository;
import com.example.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/25 11:16
 * @Version 1.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityDao activityDao;

    @Override
    public int importAll() {
        List<Activity> activityList = activityDao.list();
        Iterable<Activity> activityIterable = activityRepository.saveAll(activityList);

        Iterator<Activity> iterator = activityIterable.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;
    }

    @Override
    public Page<Activity> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return activityRepository.findByActivityName(keyword, pageable);
    }
}
