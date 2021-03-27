package com.springboot.dao.impl;

import com.springboot.dao.SysLogDao;
import com.springboot.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/5 9:38
 * @Version 1.0
 */
@Repository
public class SysLogDaoImpl implements SysLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSysLog(SysLog syslog) {
        String sql = "insert into sys_log (id,username,operation,time,method,params,ip,create_time) values(seq_sys_log.nextval,:username,:operation,:time,:method,:params,:ip,:createTime)";
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(syslog));
    }
}
