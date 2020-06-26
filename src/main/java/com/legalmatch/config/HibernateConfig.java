/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalmatch.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author loucarmendoza
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {
    
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    
    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2Ddl;
    
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(jdbcUrl);
        ds.setDriverClassName(jdbcDriver);
        ds.setUsername(username);
        ds.setPassword(password);
        
        return ds;
    }
    
    
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
    
        
    @Bean
    public LocalSessionFactoryBean getSessionFactory()
    {
        LocalSessionFactoryBean lb = new LocalSessionFactoryBean();
        lb.setPackagesToScan("com.legalmatch.models");
        lb.setDataSource(getDataSource());
        lb.setHibernateProperties(getHibernateProperties());
        return lb;
    }

    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2Ddl);
        properties.put("hibernate.use_sql_comments", true);
        
        
        return properties;
    }
    
}
