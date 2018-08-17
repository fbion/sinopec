package com.sensenets.sinopec.core.security.util;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sensenets.sinopec.core.security.entity.AuthorityName;

/**
 * Spring Security工具类
 * 
 * @author xupengtao
 * @date 2016年3月22日
 */
public class SecurityHelper {

    /**
     * @Title: getCurrentUserId
     * @Description: 获取当前用户的UserId
     * @return String
     */
    public static String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    /**
     * @Title: logout
     * @param request 请求
     * @Description: 退出登陆
     */
    public static void logout(HttpServletRequest request) {
        // 使session失效
        HttpSession session = request.getSession(false);  
        if (session != null) {  
            session.invalidate();  
        }  
        // 清空授权
        SecurityContextHolder.getContext().setAuthentication(null); 
        SecurityContextHolder.clearContext();
    }

    /**
     * @Title: isAuthority
     * @Description: 判断用户是否具有某权限
     * @param authId
     *            String
     * @return boolean
     */
    public static boolean isAuthority(String authId) {

        if (StringUtils.isBlank(authId)) {
            return false;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().size() > 0) {
            Iterator<? extends GrantedAuthority> iter = auth.getAuthorities().iterator();
            while (iter.hasNext()) {
                GrantedAuthority ga = iter.next();
                if (authId.equals(ga.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Title: getUserRole
     * @Description: 获取当前用户的角色
     * @return String
     */
    public static String getUserRole() {
        Object[] authorities = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).toArray();
        return AuthorityName.getName(ObjectUtils.toString(authorities[0]));
    }

}