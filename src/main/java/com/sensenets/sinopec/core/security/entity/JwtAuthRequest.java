package com.sensenets.sinopec.core.security.entity;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
  * @ClassName: JwtAuthRequest
  * @Description: jwt认证请求
  * @author think
  * @date 2018年8月8日 下午1:41:37
  *
  */

@Data
@ApiModel(value="JwtAuthRequest",description="JWT认证对象")
public class JwtAuthRequest implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8445943548965154778L;

    /**
     * username
     */
    @ApiModelProperty(value="用户名",name="username")
    private String username;

    /**
     * password
     */
    @ApiModelProperty(value="密码",name="password")
    private String password;

    /**
     * 扩展字段
     */
    @ApiModelProperty(value="扩展字段",name="ext")
    private String ext;

    public JwtAuthRequest() {
        super();
    }

    public JwtAuthRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }


}
