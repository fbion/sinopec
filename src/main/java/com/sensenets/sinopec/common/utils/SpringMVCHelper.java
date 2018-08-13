package com.sensenets.sinopec.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: SpringMVCHelper
 * @Description: Spring MVC 助手类
 * @author xupengtao
 * @date 2016年6月8日 下午1:34:19
 *
 */
@Slf4j
public class SpringMVCHelper {

    /**
     * @Title: getRequest
     * @Description: 获取Request
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * @Title: getResponse
     * @Description: 获取Response
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * @Title: writeJson
     * @Description: 返回json
     * @param jsonString
     *            String
     * @throws Exception
     *             异常
     */
    public static void writeJson(String jsonString) throws Exception {
        HttpServletResponse response = getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    /**
     * @Title: writeJson
     * @Description: 返回json
     * @param obj
     *            Object
     * @throws Exception
     *             异常
     */
    public static void writeJson(Object obj) throws Exception {
        HttpServletResponse response = getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(new GsonBuilder().create().toJson(out));
        out.flush();
        out.close();
    }

    /**
     * @Title: getParameter
     * @Description: 获取参数
     * @param paramName
     *            String
     * @return String
     */
    public static String getParameter(String paramName) {
        return getRequest().getParameter(paramName);
    }

    /**
     * @Title: setParameter
     * @Description: 设置属性
     * @param paramName
     *            String
     * @param paramValue
     *            Object
     */
    public static void setAttribute(String paramName, Object paramValue) {
        getRequest().setAttribute(paramName, paramValue);
    }

    /**
     * @Title: getAttribute
     * @Description: 获取属性
     * @param paramName
     *            属性名
     * @return String
     */
    public static String getAttribute(String paramName) {
        return ObjectUtils.toString(getRequest().getAttribute(paramName));
    }

    /**
     * @Title: showParams
     * @Description: 打印每个请求的参数
     * @throws IOException
     *             异常
     */
    public static void showParams() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration<String> paramNames = getRequest().getParameterNames();
        
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();

            String[] paramValues = getRequest().getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        Set<Map.Entry<String, Object>> set = map.entrySet();
        log.info(String.format("%s%s", "====>", getRequest().getRequestURI()));
        if (null != set && !set.isEmpty()) {
            for (Map.Entry<String, Object> entry : set) {
                log.info(String.format("%s%s%s", entry.getKey(), ":", entry.getValue()));
            }
        } 
        
    }

    /**
     * @Title: getUri
     * @Description: 获取request rui
     * @return String
     */
    public static String getUri() {
        return getRequest().getRequestURI();
    }

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     * 
     * @param request
     * @return String
     * @throws IOException
     */
    public static final String getIpAddr() {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("X-Forwarded-For");
        if (log.isInfoEnabled()) {
            log.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Real-IP");
                if (log.isInfoEnabled()) {
                    log.error("getIpAddress(HttpServletRequest) - X-Real-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (log.isInfoEnabled()) {
                    log.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
    
    /**
      * @Title: getHost
      * @Description: 获取host
      * @return host
     */
    public static final String getHost() {
        HttpServletRequest request = getRequest();
        return request.getHeader("host");
    }

}
