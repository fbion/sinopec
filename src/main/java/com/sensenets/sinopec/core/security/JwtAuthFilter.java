package com.sensenets.sinopec.core.security;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

/**
  * @ClassName: JwtAuthenticationTokenFilter
  * @Description: 封装登陆信息(本类不要加Component注解否则无法创建JwtAuthFilter对象)
  * @author think  UsernamePasswordAuthenticationFilter
  * @date 2018年8月8日 上午9:51:58
  *
  */
public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;
        try (InputStream is = request.getInputStream()) {
            // 使用JsonPath读取JSON请求，你也可以换成你喜欢的库
            DocumentContext context = JsonPath.parse(is);
            String username = context.read("$.username", String.class);
            String password = context.read("$.password", String.class);
            authRequest = new UsernamePasswordAuthenticationToken(username, password);
        } catch (IOException e) {
            e.printStackTrace();
            authRequest = new UsernamePasswordAuthenticationToken("", "");
        }
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}