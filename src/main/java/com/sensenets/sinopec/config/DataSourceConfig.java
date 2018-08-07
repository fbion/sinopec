package com.sensenets.sinopec.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.sensenets.sinopec.common.exception.SystemException;
import com.sensenets.sinopec.common.utils.JasyptUtil;

import lombok.Data;


/**
  * @ClassName: DruidConfig
  * @Description: druid配置
  * @author think
  * @date 2018年8月5日 下午6:07:29
  *
  */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

	private String url;// 1

	private String username;// 2

	private String password;// 3

	private String driverClassName;// 4

	private Integer initialSize;// 5

	private Integer minIdle;// 6

	private Integer maxActive;// 7

	private Integer maxWait;// 8

	private Long timeBetweenEvictionRunsMillis;// 9

	private Long minEvictableIdleTimeMillis;// 10

	private String validationQuery;// 11

	private Boolean testWhileIdle;// 12

	private Boolean testOnBorrow;// 13

	private Boolean testOnReturn;// 14

	private Boolean poolPreparedStatements;// 15

	private Integer maxPoolPreparedStatementPerConnectionSize;// 16

	private String filters;// 17

	private String connectionProperties;// 18

	@Bean(name = "dataSource")
	@Primary
	public DataSource DataSource() throws SQLException {

		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(convertProperty(username));
		dataSource.setPassword(convertProperty(password));
		dataSource.setDriverClassName(driverClassName);
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxWait(maxWait);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setPoolPreparedStatements(poolPreparedStatements);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		dataSource.setFilters(filters);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setConnectionProperties(connectionProperties);
		return dataSource;
	}

	protected String convertProperty(String propertyValue) {
		if (isEncryptPropertyVal(propertyValue)) {
			String descryptSTr = null;
			try {
				int startIndex = propertyValue.indexOf("(") + 1;
				int endIndex = propertyValue.indexOf(")");
				propertyValue = propertyValue.substring(startIndex, endIndex);
				descryptSTr = JasyptUtil.getInstance().Decript(propertyValue);
			} catch (EncryptionOperationNotPossibleException e) {
				LOGGER.error(e.getMessage(), e);
				throw new SystemException(300, String.format("配置文件[%s]属性格式不正确，请检查!!!", "application.properties"));
			}
			return descryptSTr;// 调用解密方法
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断属性值是否需要解密，这里我约定需要解密的属性名用encrypt开头
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptPropertyVal(String propertyName) {
		if (propertyName.startsWith(JasyptUtil.PREFIX)) {
			return true;
		} else {
			return false;
		}
	}

	
}
