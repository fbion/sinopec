package com.sensenets.sinopec.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = DataSourceOneConfig.PACKAGE, sqlSessionFactoryRef = "oneSqlSessionFactory")
public class DataSourceOneConfig {

    static final String PACKAGE = "com.sensenets.sinopec.buiness.dao.one";
    static final String MAPPER_LOCATION ="classpath:com/sensenets/sinopec/buiness/dao/one/*Mapper.xml" ;

    
    @Bean(name = "oneDataSource" , destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource.one.druid")
    @Primary
    public DataSource oneDataSource() {
        return DruidDataSourceBuilder
                .create()
                .build();
   }
    
   
    @Bean(name = "oneTransactionManager")
    @Primary
    public DataSourceTransactionManager oneTransactionManager() {
        return new DataSourceTransactionManager(oneDataSource());
    }

    @Bean(name = "oneSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("oneDataSource") DataSource oneDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(oneDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceOneConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
    



}