package com.springboot.dao.impl;

import com.springboot.dao.StudentDao;
import com.springboot.domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 14:42
 * @Version 1.0
 */
@Repository("studentDaoImpl2")
public class StudentDaoImpl2 implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> list(int offset, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setFirstResult(offset);
        criteria.setMaxResults(pageSize);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public Student readById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("id", id));
        List<Student> studentList = criteria.list();
        if (null != studentList && studentList.size() > 0) {
            return studentList.get(0);
        }
        return new Student();
    }
}
