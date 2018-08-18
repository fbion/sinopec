package com.sensenets.sinopec.common.startup;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;



/**
  * @ClassName: SystemInitStartup
  * @Description: 系统初始化启动(spring容器启动时启动)
  * @author think
  * @date 2018年8月18日 上午11:36:55
  *
  */
@Component
@Slf4j
public class SystemInitStartup implements ApplicationListener<ContextRefreshedEvent> {
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("程序正在启动中......");
    }
}