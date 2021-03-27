package com.springboot.service.impl;

import com.springboot.dao.StudentDao;
import com.springboot.domain.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 14:46
 * @Version 1.0
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("studentDaoImpl2")
    private StudentDao studentDao;

    @Override
    public List<Student> list(int offset, int pageSize) {
        return studentDao.list(offset, pageSize);
    }

    @Override
    public Student readById(long id) {
        return studentDao.readById(id);
    }
}
