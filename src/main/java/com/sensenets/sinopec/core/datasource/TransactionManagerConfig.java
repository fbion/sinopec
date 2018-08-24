package com.sensenets.sinopec.core.datasource;

 
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
 
 
@Configuration
@ComponentScan
@EnableTransactionManagement
public class TransactionManagerConfig {
    
    @Autowired
    @Qualifier("oneDataSource")
    private DataSource oneDataSource;
    
    @Autowired
    @Qualifier("twoDataSource")
    private DataSource twoDataSource;
  
   
    /**
      * @Title: dynamicDataSource
      * @Description: 核心动态数据源
      * @return 数据源实例
      */
    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(oneDataSource);
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceKey.DS1,oneDataSource);
        dataSourceMap.put(DataSourceKey.DS2,twoDataSource);
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }
	
	@Bean(name = "userTransaction")
	public UserTransaction userTransaction() throws Throwable {
		UserTransactionImp userTransactionImp = new UserTransactionImp();
		userTransactionImp.setTransactionTimeout(10000);
		return userTransactionImp;
	}
	
	@Bean(name = "atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
	public TransactionManager atomikosTransactionManager() throws Throwable {
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		userTransactionManager.setForceShutdown(false);
		return userTransactionManager;
	}
	
	@Bean(name = "transactionManager")
	@DependsOn({ "userTransaction", "atomikosTransactionManager" })
	public JtaTransactionManager transactionManager() throws Throwable {
	    JtaTransactionManager  manager =  new JtaTransactionManager(userTransaction(),atomikosTransactionManager());
		return manager;
	}
 
 
}
