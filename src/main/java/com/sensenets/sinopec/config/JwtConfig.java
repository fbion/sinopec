/**
 * Copyright: Copyright (c) 2017 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author xzc
 * @date 2017年8月7日 上午10:49:33
 * @version V1.0
 */
package com.sensenets.sinopec.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


/**
  * @ClassName: JwtConfig
  * @Description: jwt配置
  * @author think
  * @date 2018年8月8日 下午1:26:14
  *
  */
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtConfig {

    private long expiration;

    private String tokenHead;

    private String exceptUrl;
    
    private String header;
    
    private String secret;
    
    private boolean swaggerEnabled = false;
    
    private boolean druidEnabled = false;

}
