package com.sensenets.sinopec.core.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sensenets.sinopec.common.utils.MD5Helper;
import com.sensenets.sinopec.config.JwtConfig;
import com.sensenets.sinopec.core.security.url.UrlAccessDecisionManager;
import com.sensenets.sinopec.core.security.url.UrlAccessDeniedHandler;
import com.sensenets.sinopec.core.security.url.UrlFilterSecurityInterceptor;
import com.sensenets.sinopec.core.security.url.UrlSecurityMetadataSource;

import lombok.extern.slf4j.Slf4j;


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
    private JwtLoginHandler jwtLoginHandler;
    
    
    @Autowired
    private  JwtTokenFilter jwtTokenFilter;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired
    private  UrlAccessDecisionManager accessDecisionManager;
    
    @Autowired
    private  UrlSecurityMetadataSource securityMetadataSource;
    
    @Autowired
    private UrlAccessDeniedHandler accessDeniedHandler;
    
    
    @Autowired
    private JwtConfig jwtConfig;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
       ProviderManager authenticationManager = new ProviderManager(Arrays.asList(authenticationProvider()));
       //不擦除认证密码，擦除会导致TokenBasedRememberMeServices因为找不到Credentials再调用UserDetailsService而抛出UsernameNotFoundException
       authenticationManager.setEraseCredentialsAfterAuthentication(false);
       return authenticationManager;
    }
   
    @Bean
    public AuthenticationProvider authenticationProvider() throws Exception {
        return new JwtAuthProvider(userDetailsService,passwordEncoder());
    }

    
    /**
      * @Title: authenticationTokenFilter
      * @Description: token过滤器
      * @return
      * @throws Exception
      */
    @Bean
    public JwtAuthFilter authFilter() throws Exception {
        JwtAuthFilter authFilter = new JwtAuthFilter();
        authFilter.setAuthenticationSuccessHandler(jwtLoginHandler);
        authFilter.setAuthenticationFailureHandler(jwtLoginHandler);
        authFilter.setAuthenticationManager(authenticationManager());
        return authFilter;
    }
    
    
    /**
      * @Title: filterSecurityInterceptor
      * @Description: url权限控制过滤拦截器
      * @return
      * @throws Exception
      */
    @Bean
    public UrlFilterSecurityInterceptor filterSecurityInterceptor() throws Exception {
        UrlFilterSecurityInterceptor urlFilterSecurityInterceptor = 
                new UrlFilterSecurityInterceptor(authenticationManager(),securityMetadataSource,accessDecisionManager);
        return urlFilterSecurityInterceptor;
    }
    
  
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

    
   
    /**
     * 密码比对方式MD5 
     * @return
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider());
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
                .csrf().ignoringAntMatchers(new String[]{"/druid/**","/favicon.ico"}).and()
                 // 没有权限禁止访问异常处理
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler) 
                //未授权处理
                .authenticationEntryPoint(unauthorizedHandler).and()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 对请求进行认证
                .authorizeRequests()
                //.antMatchers(new String[]{"/druid/**","/favicon.ico"}).permitAll()
                .antMatchers(new String[]{
                        "//swagger-ui.html"
                        ,"/swagger-resources/**"
                        ,"/webjars/**"
                        ,"/v2/api-docs"
                        ,"/configuration/ui"
                        ,"/configuration/security"
                        }).permitAll()
                .antMatchers("/login").permitAll()
                 // 所有请求需要身份认证
                .anyRequest().authenticated();
               
        httpSecurity.formLogin();
        //将JWT验证添加在密码验证前面
        httpSecurity.addFilterBefore(jwtTokenFilter,UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterAt(authFilter(),UsernamePasswordAuthenticationFilter.class);
        //将url验证添加在默认拦截器FilterSecurityInterceptor验证位置
        httpSecurity.addFilterAt(filterSecurityInterceptor(),FilterSecurityInterceptor.class);
        // 禁用缓存
        httpSecurity.headers().cacheControl();
    }
    
    /**
     * 本方法如果开启了 忽略规则后，自定义的拦截仍然会拦截下面的文件，所以暂时注释掉
      */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置忽略规则
        List<String> ignoreList = new ArrayList<String>();
        if(!jwtConfig.isDruidEnabled()){
            ignoreList.add("/druid/**");
            ignoreList.add("/favicon.ico");
        }
        if(!jwtConfig.isSwaggerEnabled()){
            ignoreList.add("/swagger-ui.html");
            ignoreList.add("/swagger-resources/**");
            ignoreList.add("/webjars/**");
            ignoreList.add("/v2/api-docs");
            ignoreList.add("/configuration/ui");
            ignoreList.add("/configuration/security");
        }
        if(CollectionUtils.isNotEmpty(ignoreList)){
            String[] ary = ignoreList.toArray(new String[ignoreList.size()]);
            web.ignoring().antMatchers(ary);
        }
    }

}