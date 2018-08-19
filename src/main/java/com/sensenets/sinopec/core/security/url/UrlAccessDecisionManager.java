package com.sensenets.sinopec.core.security.url;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils;
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

/**
 * AccessdecisionManager在Spring security中是很重要的。
 * 
 * 在验证部分简略提过了，所有的Authentication实现需要保存在一个GrantedAuthority对象数组中。 这就是赋予给主体的权限。
 * GrantedAuthority对象通过AuthenticationManager 保存到
 * Authentication对象里，然后从AccessDecisionManager读出来，进行授权判断。
 * 
 * Spring Security提供了一些拦截器，来控制对安全对象的访问权限，例如方法调用或web请求。
 * 一个是否允许执行调用的预调用决定，是由AccessDecisionManager实现的。 这个 AccessDecisionManager
 * 被AbstractSecurityInterceptor调用， 它用来作最终访问控制的决定。
 * 这个AccessDecisionManager接口包含三个方法：
 * 
 * void decide(Authentication authentication, Object secureObject,
 * List<ConfigAttributeDefinition> config) throws AccessDeniedException; boolean
 * supports(ConfigAttribute attribute); boolean supports(Class clazz);
 * 
 * 从第一个方法可以看出来，AccessDecisionManager使用方法参数传递所有信息，这好像在认证评估时进行决定。
 * 特别是，在真实的安全方法期望调用的时候，传递安全Object启用那些参数。 比如，让我们假设安全对象是一个MethodInvocation。
 * 很容易为任何Customer参数查询MethodInvocation，
 * 然后在AccessDecisionManager里实现一些有序的安全逻辑，来确认主体是否允许在那个客户上操作。
 * 如果访问被拒绝，实现将抛出一个AccessDeniedException异常。
 * 
 * 这个 supports(ConfigAttribute) 方法在启动的时候被
 * AbstractSecurityInterceptor调用，来决定AccessDecisionManager
 * 是否可以执行传递ConfigAttribute。 supports(Class)方法被安全拦截器实现调用，
 * 包含安全拦截器将显示的AccessDecisionManager支持安全对象的类型。
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
        boolean isAnonymousUser = ObjectUtils.toString(authentication.getPrincipal()).equals("anonymousUser") ;
        if (isAnonymousUser) {
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
