package com.sensenets.sinopec.core.security.url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sensenets.sinopec.common.domain.ResponseInfo;

/**
  * @ClassName: UrlAccessDeniedHandler
  * @Description: url拒绝访问异常操作
  * @author think
  * @date 2018年8月17日 下午9:02:16
  *
  */
@Component
public class UrlAccessDeniedHandler implements AccessDeniedHandler {
 
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        responseJson(response,accessDeniedException);
    }
 
    private void responseJson(HttpServletResponse response,AccessDeniedException accessDeniedException){
        response.setHeader("content-type", "application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            ResponseInfo info = new ResponseInfo();
            info.setCode(HttpServletResponse.SC_FORBIDDEN);
            info.setMessage("访问的资源权限不存在，请检查资源信息或联系管理员！");
            info.setStatus(ResponseInfo.Status.ERROR);
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
