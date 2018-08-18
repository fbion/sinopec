/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月18日 下午12:00:57
 * @version V1.0
 */
package com.sensenets.sinopec.common.startup;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
  * @ClassName: SystemApplicationContextInitializer
  * @Description: initialize方法在容器启动之前进行调用
  * @author think
  * @date 2018年8月18日 下午12:00:57
  *
  */
@Slf4j
public class SysAppContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // fastjson首字母大写自动转成小写问题解决
        System.setProperty("TypeUtils.compatibleWithJavaBean", "true");
        log.info("---- Set System Property Finish  ！----");
        log.info("程序准备启动");
    }

    
}
