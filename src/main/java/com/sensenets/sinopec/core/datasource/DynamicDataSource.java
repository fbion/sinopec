package com.sensenets.sinopec.core.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;


/**
  * @ClassName: DynamicDataSource
  * @Description: 动态数据源
  * @author think
  * @date 2018年8月23日 下午10:40:45
  *
  */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
	    log.debug("当前数据源===>"+DataSourceContextHolder.get());
		return DataSourceContextHolder.get();
	}
    
}
