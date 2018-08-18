/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月19日 上午12:43:33
 * @version V1.0
 */
package com.sensenets.sinopec.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
  * @ClassName: AuthCredentialsNotFoundException
  * @Description: 自定义权限不足异常进行捕获
  * @author think
  * @date 2018年8月19日 上午12:43:33
  *
  */
public class AuthCredentialsNotFoundException  extends AuthenticationException{

  
    public AuthCredentialsNotFoundException(String msg) {
        super(msg);
    }

    /**
      * @Fields serialVersionUID : 
      */
    private static final long serialVersionUID = -2519495365872586164L;
    
}
