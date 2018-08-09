package com.sensenets.sinopec.core.security.entity;
import java.io.Serializable;

import lombok.Data;


/**
  * @ClassName: JwtAuthRequest
  * @Description: jwt认证请求
  * @author think
  * @date 2018年8月8日 下午1:41:37
  *
  */
@Data
public class JwtAuthRequest implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8445943548965154778L;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * 扩展字段
     */
    private String ext;

    public JwtAuthRequest() {
        super();
    }

    public JwtAuthRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }


}
