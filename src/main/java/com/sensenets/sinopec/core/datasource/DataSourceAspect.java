package com.sensenets.sinopec.core.datasource;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
// 此处一定要先于事务切面执行
@Order(1)
public class DataSourceAspect {
	

	@Before("execution(* com.sensenets.sinopec.buiness.dao.one.*.*(..)) ")
	public void doChangeDataSource(JoinPoint jp) {
		String cName = jp.getSignature().getDeclaringTypeName();
		DataSourceContextHolder.set(DataSourceKey.DS1);
		log.info("====>接口：" + StringUtils.substringAfterLast(cName, ".") + ",use datasource:" +DataSourceContextHolder.get());
	}
	
	@Before("execution(* com.sensenets.sinopec.buiness.dao.two.*.*(..)) ")
	public void ChangeDataSource(JoinPoint jp) {
		String cName = jp.getSignature().getDeclaringTypeName();
		DataSourceContextHolder.set(DataSourceKey.DS2);
		log.info("====>接口："  + StringUtils.substringAfterLast(cName, ".") + ",use datasource:" + DataSourceContextHolder.get());
	}
	
}