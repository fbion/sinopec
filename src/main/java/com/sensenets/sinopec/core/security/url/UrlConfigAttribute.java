package com.sensenets.sinopec.core.security.url;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.ConfigAttribute;

import com.sensenets.sinopec.common.enums.UrlMethod;

import lombok.Getter;


/**
  * @ClassName: UrlConfigAttribute
  * @Description: url配置属性
  * @author think
  * @date 2018年8月17日 上午10:43:42
  *
  */
@Getter
public class UrlConfigAttribute implements ConfigAttribute {

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = -4518677365178137279L;
    
    private final HttpServletRequest httpServletRequest;
    
    private final UrlGrantedAuthority requestAuthority;
    
    private final UrlGrantedAuthority requestPathAuthority;

    public UrlConfigAttribute(HttpServletRequest request) {
        this.httpServletRequest = request;
        String method = request.getMethod();
        this.requestAuthority = new UrlGrantedAuthority(request.getRequestURI(),UrlMethod.getEnumType(method));
        String url = StringUtils.substringBeforeLast(request.getRequestURI(), "/")+"/"+"**";
        this.requestPathAuthority = new UrlGrantedAuthority(url,UrlMethod.getEnumType(method));
    }

    

    @Override
    public String getAttribute() {
        return null;
    }

   
}