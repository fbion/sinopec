package com.sensenets.sinopec.core.security.url;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.sensenets.sinopec.common.exception.AuthCredentialsNotFoundException;
/**
 * @ClassName: UrlFilterSecurityInterceptor
 * @Description: url过滤拦截器
 * @author think
 * @date 2018年8月17日 上午10:45:14
 *
 */

public class UrlFilterSecurityInterceptor extends FilterSecurityInterceptor {

    public UrlFilterSecurityInterceptor(AuthenticationManager authenticationManager,
            FilterInvocationSecurityMetadataSource securityMetadataSource,
            AccessDecisionManager accessDecisionManager
            ){
        super.setAuthenticationManager(authenticationManager);
        super.setSecurityMetadataSource(securityMetadataSource);
        super.setAccessDecisionManager(accessDecisionManager);
    }
    
    /**
     * @Description: 
     * 1.fi里面有一个被拦截的url资源
     * 2.里面调用UrlSecurityMetadataSource的getAttributes(Object object)这个方法获取fi资源对应的所有权限
     * 3.再调用UrlAccessDecisionManager的decide方法来校验用户的权限是否足够
     * @param request 请求
     * @param response 响应
     * @param chain 过滤器链
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        InterceptorStatusToken  token = null;
        try {
            token = super.beforeInvocation(fi);
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }catch(AuthenticationCredentialsNotFoundException e){
            e.printStackTrace();
            throw new AuthCredentialsNotFoundException("权限不足");
        }finally {
            super.afterInvocation(token, null);
        }
    }
    
}


