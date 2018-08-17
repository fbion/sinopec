package com.sensenets.sinopec.core.security.url;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.sensenets.sinopec.buiness.model.VjFuncRoleUrlView;
import com.sensenets.sinopec.buiness.service.IVjFuncRoleUrlViewService;
import com.sensenets.sinopec.common.enums.UrlMethod;

/**
 * @ClassName: UrlMetadataSourceService
 * @Description: 通过URL地址获取相应权限然后在获取相应的角色集合
 * @author think
 * @date 2018年8月17日 上午10:48:01
 *
 */
@Service
public class UrlSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    /**
      * @Fields ROLE_NO_EXIST : 资源权限不存在默认角色
      */
    public static final String ROLE_NO_EXIST = "ROLE_NO_EXIST";
    
    @Autowired
    private IVjFuncRoleUrlViewService funcRoleUrlViewService;

    private static Map<UrlGrantedAuthority, Set<ConfigAttribute>> resourceMap = null;

    /**
     * @Title: loadResourceDefine
     * @Description: 加载定义的所有权限资源
     */
    @PostConstruct
    private void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<UrlGrantedAuthority, Set<ConfigAttribute>>();
            List<VjFuncRoleUrlView> resources = funcRoleUrlViewService.findAll();
            // 一个资源可以被多个角色访问，根据资源分组，统计每个资源对应的角色名称
            for (VjFuncRoleUrlView resource : resources) {
                Set<ConfigAttribute> configAttributes = null;
                String url = StringUtils.substringAfterLast(resource.getFuncUri(), " ");
                String method = StringUtils.substringBefore(resource.getFuncUri(), " ");
                UrlGrantedAuthority authority = new UrlGrantedAuthority(url, UrlMethod.getEnumType(method));
                if (resourceMap.get(authority) == null) {
                    configAttributes = new HashSet<ConfigAttribute>();
                    ConfigAttribute attribute = new SecurityConfig(resource.getFuncRoleId());
                    configAttributes.add(attribute);
                } else {
                    configAttributes = resourceMap.get(authority);
                    ConfigAttribute attribute = new SecurityConfig(resource.getFuncRoleId());
                    configAttributes.add(attribute);
                }
                resourceMap.put(authority, configAttributes);
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        if (resourceMap == null) {
            loadResourceDefine();
        }
        UrlConfigAttribute attribute = new UrlConfigAttribute(request);
        Set<ConfigAttribute> configAttributes = resourceMap.get(attribute.getRequestAuthority());
        if(CollectionUtils.isEmpty(configAttributes)){
            // 此处为空需要判断并添加默认的资源不存在权限，否则自定义的AccessDecisionManager不执行
            configAttributes = new HashSet<ConfigAttribute>();
            configAttributes.add(new SecurityConfig(ROLE_NO_EXIST));
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
