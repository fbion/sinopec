package com.sensenets.sinopec.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sensenets.sinopec.common.interceptor.RequestParamsInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private FastJsonHttpMessageConverter fastJsonHttpMessageConverter;
    
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestParamsInterceptor());
        super.addInterceptors(registry);
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置swagger2的url映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
           super.configureMessageConverters(converters);
           converters.add(fastJsonHttpMessageConverter);
    }




}