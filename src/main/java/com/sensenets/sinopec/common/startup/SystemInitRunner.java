/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月18日 上午11:47:17
 * @version V1.0
 */
package com.sensenets.sinopec.common.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
  * @ClassName: SystemRunner
  * @Description: 在spring boot容器启动完成后启动（其他的ApplicationRunner也可以实现该功能）
  * @author think
  * @date 2018年8月18日 上午11:47:17
  */
@Component
@Slf4j
@Order(-1)
public class SystemInitRunner implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        log.info("程序启动完成");
    }

}
