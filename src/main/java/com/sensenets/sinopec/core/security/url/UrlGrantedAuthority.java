package com.sensenets.sinopec.core.security.url;

import org.springframework.security.core.GrantedAuthority;

import com.sensenets.sinopec.common.enums.UrlMethod;

import lombok.Data;

/**
  * @ClassName: UrlGrantedAuthority
  * @Description: url访问权限
  * @author think
  * @date 2018年8月17日 上午10:20:07
  *
  */
@Data
public class UrlGrantedAuthority implements GrantedAuthority {

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = 9060059791387906332L;
    
    /**
      * @Fields permissionUrl : 授权url
      */
    private String permissionUrl;
    
    /**
      * @Fields method : url方法(POST,GET,PUT,DELETE)
      */
    private UrlMethod method;

    public UrlGrantedAuthority (String permissionUrl, UrlMethod method) {
        this.permissionUrl = permissionUrl;
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.permissionUrl + ";"+this.method;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof UrlGrantedAuthority))
            return false;
        UrlGrantedAuthority authority = (UrlGrantedAuthority)obj;
        return authority.getPermissionUrl().equals(permissionUrl) && authority.getMethod().equals(method);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * permissionUrl.hashCode();
        result += 31 * method.hashCode();
        return result;
    }
    public static void main(String[] args) {
        UrlGrantedAuthority  u1= new UrlGrantedAuthority("12",UrlMethod.POST);
        UrlGrantedAuthority  u2= new UrlGrantedAuthority("12",UrlMethod.POST);
        System.out.println(u1.equals(u2));
    }
}
