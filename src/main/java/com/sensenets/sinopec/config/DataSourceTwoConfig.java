package com.sensenets.sinopec.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@EnableTransactionManagement 
@MapperScan(basePackages = DataSourceTwoConfig.PACKAGE, sqlSessionFactoryRef = "twoSqlSessionFactory")
public class DataSourceTwoConfig {

    static final String PACKAGE = "com.sensenets.sinopec.buiness.dao.two";
    static final String MAPPER_LOCATION ="classpath:com/sensenets/sinopec/buiness/dao/two/*Mapper.xml" ;


    @Bean(name = "twoDataSource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource.two.druid")
    public DataSource twoDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "twoTransactionManager")
    public DataSourceTransactionManager twoTransactionManager() {
        return new DataSourceTransactionManager(twoDataSource());
    }

    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("twoDataSource") DataSource twoDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(twoDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceTwoConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}