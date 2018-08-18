/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月18日 下午8:45:30
 * @version V1.0
 */
package com.sensenets.sinopec.core.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.sensenets.sinopec.core.security.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

/**
  * @ClassName: JwtTokenFilter
  * @Description: token过滤器
  * @author think
  * @date 2018年8月18日 下午8:45:30
  *
  */
@Component
@Slf4j
public class JwtTokenFilter  implements Filter{
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null) {
            // 如果带有"Bearer "截取"Bearer "之后的token字符串，否则直接获取
            final String authToken = authHeader.startsWith(tokenHead)?authHeader.substring(tokenHead.length()+1):authHeader; 
            String useraccount = null;
            try {
                useraccount = jwtUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                log.error("认证获取令牌异常！", e);
            } catch (ExpiredJwtException e) {
                log.warn("认证令牌过期！", e);
            } catch(SignatureException e){
                log.error("认证失败 ，用户名或者密码错误！");
            }
            log.debug("JwtAuthTokenFilter[doFilterInternal] checking authentication " + useraccount);
            if (useraccount != null && SecurityContextHolder.getContext().getAuthentication() == null) {//token校验通过
                //根据account去数据库中查询user数据，足够信任token的情况下，可以省略这一步
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(useraccount);
                if (jwtUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    log.debug("JwtAuthTokenFilter[doFilterInternal]  authenticated user " + useraccount + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }else {
            log.info("忽略的url:"+request.getRequestURI());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

   
    @Override
    public void destroy() {
        
    }

}
