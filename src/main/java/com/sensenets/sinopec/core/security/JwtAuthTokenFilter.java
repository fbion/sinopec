package com.sensenets.sinopec.core.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sensenets.sinopec.core.security.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

/**
  * @ClassName: JwtAuthenticationTokenFilter
  * @Description: 验证token
  * @author think
  * @date 2018年8月8日 上午9:51:58
  *
  */
@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        if (authHeader != null) {
            // 如果带有"Bearer "截取"Bearer "之后的token字符串，否则直接获取
            final String authToken = authHeader.startsWith(tokenHead)?authHeader.substring(tokenHead.length()+1):authHeader; 
            String useraccount = null;
            try {
                useraccount = jwtUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("认证获取令牌异常！", e);
            } catch (ExpiredJwtException e) {
                logger.warn("认证令牌过期！", e);
            } catch(SignatureException e){
                logger.error("认证失败 ，用户名或者密码错误！");
            }
            logger.debug("JwtAuthTokenFilter[doFilterInternal] checking authentication " + useraccount);
            if (useraccount != null && SecurityContextHolder.getContext().getAuthentication() == null) {//token校验通过
                //根据account去数据库中查询user数据，足够信任token的情况下，可以省略这一步
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(useraccount);
                if (jwtUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            httpServletRequest));
                    logger.debug("JwtAuthTokenFilter[doFilterInternal]  authenticated user " + useraccount + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }else {
            logger.debug("忽略的url:"+httpServletRequest.getRequestURI());
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}