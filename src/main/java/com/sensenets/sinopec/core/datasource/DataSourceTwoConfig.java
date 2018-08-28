package com.sensenets.sinopec.core.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.xa.DruidXADataSource;

@Configuration
@MapperScan(basePackages = DataSourceTwoConfig.DAO_PACKAGE, sqlSessionFactoryRef = "twoSqlSessionFactory")
public class DataSourceTwoConfig {

    /**
     * @Fields DAO_PACKAGE : 对接数据库的接口层
     */
   static final String DAO_PACKAGE = "com.sensenets.sinopec.buiness.dao.two";
   /**
     * @Fields MODEL_PACKAGE : 对接数据库的实体层
     */
   static final String MODEL_PACKAGE = "com.sensenets.sinopec.buiness.model.two";
   
   /**
     * @Fields MAPPER_LOCATION : xml文件位置
     */
   static final String MAPPER_LOCATION ="classpath:com/sensenets/sinopec/buiness/dao/two/*/*Mapper.xml" ;

   static final String  PREFIX = "spring.datasource.two.druid.";
   
    @Autowired
    private Environment env;
    
    private String get(String key){
        return env.getProperty(String.format("%s%s", PREFIX,key));
    }
     
    
    @Bean(name = "twoDataSource" , destroyMethod = "close", initMethod = "init")
    @Primary
    public DataSource twoDataSource() throws SQLException {
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSourceClassName(env.getProperty("spring.datasource.type"));
        ds.setUniqueResourceName("twoDataSource");
        DruidXADataSource data = new DruidXADataSource();
        data.setName(get("name"));
        data.setDriverClassName(get("driverClassName"));
        data.setUrl(get("url"));
        data.setUsername(get("username"));
        data.setPassword(get("password"));
        data.setInitialSize(NumberUtils.toInt(get("initialSize")));
        data.setMaxActive(NumberUtils.toInt(get("maxActive")));
        data.setMinIdle(NumberUtils.toInt(get("minIdle")));
        data.setMaxWait(NumberUtils.toInt(get("maxWait")));
        data.setValidationQuery(get("validationQuery"));
        data.setTestOnBorrow(BooleanUtils.toBoolean(get("testOnBorrow")));
        data.setTestOnReturn(BooleanUtils.toBoolean(get("testOnReturn")));
        data.setTestWhileIdle(BooleanUtils.toBoolean(get("testWhileIdle")));
        data.setTimeBetweenEvictionRunsMillis(NumberUtils.toLong(get("timeBetweenEvictionRunsMillis")));
        data.setMinEvictableIdleTimeMillis(NumberUtils.toLong(get("minEvictableIdleTimeMillis")));
        data.setPoolPreparedStatements(BooleanUtils.toBoolean(get("poolPreparedStatements")));
        data.setMaxPoolPreparedStatementPerConnectionSize(NumberUtils.toInt(get("maxPoolPreparedStatementPerConnectionSize")));
        data.setFilters(get("filters"));
        data.setConnectionProperties(get("connectionProperties"));
        data.setUseGlobalDataSourceStat(BooleanUtils.toBoolean(get("useGlobalDataSourceStat")));
        ds.setXaDataSource(data);
        return ds;
   }
    
 

    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("twoDataSource") DataSource twoDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(twoDataSource);
        sessionFactory.setVfs(SpringBootVFS.class);
        sessionFactory.setTypeAliasesPackage(MODEL_PACKAGE);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceTwoConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
    
    @Bean(name = "twoSqlSessionTemplate")
    public SqlSessionTemplate twoSqlSessionTemplate(@Qualifier("twoDataSource") DataSource twoDataSource) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(twoSqlSessionFactory(twoDataSource)); // 使用上面配置的Factory
        return template;
    }
    
}