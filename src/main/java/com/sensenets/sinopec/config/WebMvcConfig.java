package com.sensenets.sinopec.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.sensenets.sinopec.common.interceptor.RequestParamsInterceptor;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {
   
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
        // 映射 resources下面的静态资源
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/resources/static/");
    }
}