package com.sensenets.sinopec.core.security.url;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;



/**
  * @ClassName: UrlAccessDecisionManager
  * @Description: url访问决策器
  * @author think
  * @date 2018年8月17日 上午10:06:38
  *
  */
@Service
@Slf4j
public class UrlAccessDecisionManager implements AccessDecisionManager {
    
    
    /**
      * 通过传递的参数来决定用户是否有访问对应受保护对象的权限
      * @param authentication 当前正在请求受保护对象的Authentication
      * @param object 受保护对象，其可以是一个MethodInvocation、JoinPoint或FilterInvocation
      * @param configAttributes 与正在请求的受保护对象相关联的配置属性
      * @throws AccessDeniedException
      * @throws InsufficientAuthenticationException
      */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        if ("anonymousUser".equals(authentication.getPrincipal())
                || matchers("/images/**", request)
                || matchers("/js/**", request)
                || matchers("/css/**", request)
                || matchers("/fonts/**", request)
                || matchers("/", request)
                || matchers("/index.html", request)
                || matchers("/favicon.ico", request)
                || matchers("/login", request)) {
            return;
        } else {
            if(configAttributes!=null&&configAttributes.size()==1) {
                configAttributes.forEach(attribute->{
                    if(attribute.getAttribute().equals(UrlSecurityMetadataSource.ROLE_NO_EXIST)){
                        throw new AccessDeniedException("您暂无权限访问，请联系管理员！");
                    }
                });
            }
            //所请求的资源拥有的权限(一个资源对多个角色权限)
            Iterator<ConfigAttribute> iterator = configAttributes.iterator();
            while(iterator.hasNext()) {
                ConfigAttribute configAttribute = iterator.next();
                //访问所请求资源所需要的角色权限
                String role = configAttribute.getAttribute();
                log.info("访问本资源："+request.getRequestURI()+" 需要角色权限："+role);
                // 用户拥有的权限authentication与访问所请求资源所需要的权限进行比较
                for (GrantedAuthority ga : authentication.getAuthorities()) {
                    if(ga instanceof SimpleGrantedAuthority){
                        SimpleGrantedAuthority simpleAuthority  = (SimpleGrantedAuthority)ga;
                        if(role.equals(simpleAuthority.getAuthority())){
                            return ;
                        }
                    }
                }
            }
        }
        throw new AccessDeniedException("您暂无权限访问，请联系管理员！");
    }


    /**
     * 表示当前AccessDecisionManager是否支持对应的ConfigAttribute
     */
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    /**
     * 表示当前AccessDecisionManager是否支持对应的受保护对象类型
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    private boolean matchers(String url, HttpServletRequest request) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }

}
