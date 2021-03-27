package com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/17 14:38
 * @Version 1.0
 */
@Configuration
public class HibernateConfig {

    @Value("${spring.datasource.druid.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.druid.url}")
    private String url;

    @Value("${spring.datasource.druid.username}")
    private String userName;

    @Value("${spring.datasource.druid.password}")
    private String password;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${spring.hibernate.show_sql}")
    private String showSql;

    @Value("${spring.hibernate.hbm2ddl.auto}")
    private String hbm2ddl;

    @Value("${spring.entitymanager.packagesToScan}")
    private String packages;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(packages);

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", dialect);
        hibernateProperties.put("hibernate.show_sql", showSql);
        hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

//    @Bean
//    public HibernateTemplate hibernateTemplate() {
//        HibernateTemplate hibernateTemplate = new HibernateTemplate();
//        hibernateTemplate.setSessionFactory(sessionFactory());
//        return hibernateTemplate;
//    }

}
