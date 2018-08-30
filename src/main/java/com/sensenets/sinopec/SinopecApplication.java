package com.sensenets.sinopec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sensenets.sinopec.common.startup.SysAppContextInitializer;
import com.sensenets.sinopec.common.utils.BeanHelper;

/**
  * @ClassName: SinopecApplication
  * @Description: jar形式运行启动类
  * @author think
  * @date 2018年8月6日 上午11:22:36
  *
  */
@EnableWebMvc
@EnableIntegration
@IntegrationComponentScan
@ServletComponentScan
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SinopecApplication {

	public static void main(String[] args) {
	    SpringApplication app = new SpringApplication(SinopecApplication.class);
        app.addInitializers(new SysAppContextInitializer());
        ApplicationContext context = app.run(args);
        BeanHelper.init(context);
	}

}
