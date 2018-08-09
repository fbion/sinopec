package com.sensenets.sinopec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
  * @ClassName: SinopecApplication
  * @Description: jar形式运行启动类
  * @author think
  * @date 2018年8月6日 上午11:22:36
  *
  */
@EnableWebMvc
@SpringBootApplication
@EnableAutoConfiguration(exclude = { JacksonAutoConfiguration.class })
@IntegrationComponentScan
public class SinopecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinopecApplication.class, args);
	}

}
