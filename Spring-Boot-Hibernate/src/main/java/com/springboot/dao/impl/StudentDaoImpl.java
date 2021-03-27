package com.springboot.dao.impl;

import com.springboot.dao.StudentDao;
import com.springboot.domain.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 14:42
 * @Version 1.0
 */
@Repository("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> list(int offset, int pageSize) {
        return sessionFactory.getCurrentSession().createQuery("from Student")
                .setFirstResult(offset)
                .setMaxResults(pageSize)
                .list();
    }

    @Override
    public Student readById(long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Student where id = :id");
        query.setString("id", String.valueOf(id));
        List<Student> studentList = query.list();
        if (null != studentList && studentList.size() > 0) {
            return studentList.get(0);
        }
        return new Student();
    }

//    public void testOpt(Student student) {
//        Session session = sessionFactory.getCurrentSession();
//        // 删除
//        session.delete(student);
//        // 更新
//        session.update(student);
//        // 新增
//        session.save(student);
//    }
}
