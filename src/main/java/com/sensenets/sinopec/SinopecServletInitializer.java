package com.sensenets.sinopec;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
  * @ClassName: SinopecServletInitializer
  * @Description: 容器中运行启动类
  * @author think
  * @date 2018年8月6日 上午11:22:22
  *
  */
public class SinopecServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SinopecApplication.class);
    }

}
