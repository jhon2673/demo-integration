package com.example.service.impl;

import com.example.dao.EsStudentDao;
import com.example.document.EsStudent;
import com.example.repository.EsStudentRepository;
import com.example.service.EsStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/9 20:56
 * @Version 1.0
 */
@Service
public class EsStudentServiceImpl implements EsStudentService {

    @Autowired
    private EsStudentDao esStudentDao;

    @Autowired
    private EsStudentRepository esStudentRepository;

    @Override
    public int importAll() {
        List<EsStudent> esStudentList = esStudentDao.getAllEsProductList(null);
        Iterable<EsStudent> esStudentIterable = esStudentRepository.saveAll(esStudentList);

        Iterator<EsStudent> iterator = esStudentIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        esStudentRepository.deleteById(id);
    }

    @Override
    public EsStudent create(Long id) {
        EsStudent result = null;
        List<EsStudent> esStudentList = esStudentDao.getAllEsProductList(id);
        if (esStudentList.size() > 0) {
            EsStudent esStudent = esStudentList.get(0);
            result = esStudentRepository.save(esStudent);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsStudent> esStudentList = new ArrayList<>();
            for (Long id : ids) {
                EsStudent esStudent = new EsStudent();
                esStudent.setId(id);
                esStudentList.add(esStudent);
            }
            esStudentRepository.deleteAll(esStudentList);
        }
    }

    @Override
    public Page<EsStudent> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esStudentRepository.findBySnoOrName(keyword, keyword, pageable);
    }
}
