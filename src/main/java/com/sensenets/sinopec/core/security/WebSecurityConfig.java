package com.sensenets.sinopec.core.security;

import com.sensenets.sinopec.common.utils.MD5Helper;
import com.sensenets.sinopec.config.JwtConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
  * @ClassName: WebSecurityConfig
  * @Description: spring security 的安全配置类
  * @author think
  * @date 2018年8月8日 上午9:55:47
  *
  */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtConfig jwtConfig;

  
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder =new PasswordEncoder(){
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Helper.toMD5(String.valueOf(rawPassword));
            }
            @Override
            public boolean matches(CharSequence submitPassword, String encodedPassword) {
                return encodedPassword.equals(submitPassword);
            }};
        return passwordEncoder;
    }

    @Bean
    public JwtAuthTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthTokenFilter();
    }
  
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
  
    /**
     * 密码比对方式MD5 
     * @return
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    /**
     * token请求授权
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()//未授权处理
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                // 除上面外的所有请求全部需要鉴权认证
//                .antMatchers(jwtConfig.getExceptUrl()).permitAll()
                .anyRequest().authenticated();

        // 添加JWT filter
        //将token验证添加在密码验证前面
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);  
        // 禁用缓存
        httpSecurity.headers().cacheControl();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置忽略规则
        web.ignoring().antMatchers(
                jwtConfig.getExceptUrl(),
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/images/**",
                "/webjars/**",
                "/v2/api-docs",
                "/configuration/ui",
                "/configuration/security",
                
                "/metrics/**",
                "/druid/**",
                "/actuator",
                "/actuator/**",
                "/favicon.ico",
                "/**/*.css",
                "/**/*.js",
                "/**/*.gif",
                "/**/*.png",
                "/**/*.ttf",
                "/**/*.jpeg",
                "/**/*.jpg"
                );
    }

}