package com.sensenets.sinopec.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sensenets.sinopec.common.utils.SpringMVCHelper;

/**
  * @ClassName: RequestParamsInterceptor
  * @Description: 请求参数拦截器
  * @author think
  * @date 2018年8月5日 下午2:30:42
  *
  */
public class RequestParamsInterceptor implements HandlerInterceptor {
    
    /**
     * LOGGER
     */
    private Logger LOGGER = LoggerFactory.getLogger(RequestParamsInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            // 拦截请求，输出所有请求参数
            SpringMVCHelper.showParams();
            
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return true;

    }

    /*
      * <p>Title: postHandle</p>
      * <p>Description: </p>
      * @param request
      * @param response
      * @param handler
      * @param modelAndView
      * @throws Exception
      * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
      */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }

    /*
      * <p>Title: afterCompletion</p>
      * <p>Description: </p>
      * @param request
      * @param response
      * @param handler
      * @param ex
      * @throws Exception
      * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
      */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }

}