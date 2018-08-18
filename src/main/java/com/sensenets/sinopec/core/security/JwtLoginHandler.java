package com.sensenets.sinopec.core.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.gson.Gson;
import com.sensenets.sinopec.common.domain.ResponseInfo;
import com.sensenets.sinopec.core.security.entity.ResponseMessage;
import com.sensenets.sinopec.core.security.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public  class JwtLoginHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
    
        @Autowired
        private JwtUtil jwtUtil;
        
        @Autowired
        private FastJsonHttpMessageConverter httpMessageConverter;
    
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
            log.info("User login successfully, name={}", authentication.getName());
            responseSuccessJson(response,authentication);
        }

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
            responseFailJson(response,exception);
        }
        
        private void responseSuccessJson(HttpServletResponse response,Authentication auth){
            response.setHeader("content-type", "application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = null;
            try {
                out = response.getWriter();
                ResponseInfo info = new ResponseInfo(
                        ResponseMessage.RESULT_SUSSECC.getIndex(), 
                        ResponseMessage.RESULT_SUSSECC.getName());
                info.setCode(HttpServletResponse.SC_OK);
                info.setData(jwtUtil.generateToken(auth));
                FastJsonConfig fastJsonConfig = httpMessageConverter.getFastJsonConfig();
                String jsonStr = JSON.toJSONString(info, 
                        fastJsonConfig.getSerializeConfig(),
                        fastJsonConfig.getSerializeFilters(), 
                        fastJsonConfig.getSerializerFeatures());
                out.println(jsonStr);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(out!=null){
                    out.close();
                }
            }
        }
        
        private void responseFailJson(HttpServletResponse response,AuthenticationException exception){
            response.setHeader("content-type", "application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = null;
            try {
                out = response.getWriter();
                ResponseInfo info = new ResponseInfo(
                        ResponseMessage.RESULT_FAIL_NAME.getIndex(), 
                        ResponseMessage.RESULT_FAIL_NAME.getName());
                info.setError(exception.getMessage());
                FastJsonConfig fastJsonConfig = httpMessageConverter.getFastJsonConfig();
                String jsonStr = JSON.toJSONString(info, 
                        fastJsonConfig.getSerializeConfig(),
                        fastJsonConfig.getSerializeFilters(), 
                        fastJsonConfig.getSerializerFeatures());
                out.println(jsonStr);
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