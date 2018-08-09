package com.sensenets.sinopec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

/**
  * @ClassName: SinopecApplication
  * @Description: jar形式运行启动类
  * @author think
  * @date 2018年8月6日 上午11:22:36
  *
  */
@EnableWebMvc
@SpringBootApplication
public class SinopecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinopecApplication.class, args);
	}
	

    @Bean
    public Module jacksonAfterBurnerModule() {
        return new AfterburnerModule();
    }

    @Bean
    public HttpMessageConverter httpSmileJackson2MessageConverter() {
        return new AbstractJackson2HttpMessageConverter(
                new ObjectMapper(new SmileFactory()).registerModule(new AfterburnerModule()),
                new MediaType("application", "x-jackson-smile")) {
        };
    }
}
