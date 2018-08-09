package com.sensenets.sinopec.core.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sensenets.sinopec.common.domain.ResponseInfo;


/**
  * @ClassName: JwtAuthenticationEntryPoint
  * @Description: jwt 未授权处理异常
  * @author think
  * @date 2018年8月8日 上午9:57:39
  *
  */
@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        responseJson(response,authException);
        return;
    }
    
    private void responseJson(HttpServletResponse response,AuthenticationException authException){
        response.setHeader("content-type", "application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            ResponseInfo info = new ResponseInfo();
            info.setCode(HttpServletResponse.SC_UNAUTHORIZED);
            info.setMessage("未授权，拒绝访问");
            out.println(new Gson().toJson(info));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(out!=null){
                out.close();
            }
        }
    }
}