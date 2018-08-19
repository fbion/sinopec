/**
 * Copyright: Copyright (c) 2017 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author xzc
 * @date 2017年8月7日 上午10:49:33
 * @version V1.0
 */
package com.sensenets.sinopec.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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

    private String header;
    
    private String secret;
    
    private boolean swaggerEnabled = false;
    
    private boolean druidEnabled = false;
    
    private boolean commonEnabled = false;
    
    
    private String druidIgnoreUrls;
    
    private String swaggerIgnoreUrls;
    
    private String commonIgnoreUrls;
    
    public List<String> getDruidIgnoreUrlList(){
        List<String> urls = new ArrayList<String>();
        if(StringUtils.isNotBlank(druidIgnoreUrls)&&druidEnabled){
            urls.addAll(Arrays.asList(druidIgnoreUrls.split(",")));
        }
        return urls;
    }
    
    public List<String> getSwaggerIgnoreUrlList(){
        List<String> urls = new ArrayList<String>();
        if(StringUtils.isNotBlank(swaggerIgnoreUrls)&&swaggerEnabled){
            urls.addAll(Arrays.asList(swaggerIgnoreUrls.split(",")));
        }
        return urls;
    }
    
    public List<String> getCommonIgnoreUrlList(){
        List<String> urls = new ArrayList<String>();
        if(StringUtils.isNotBlank(commonIgnoreUrls)&&commonEnabled){
            urls.addAll(Arrays.asList(commonIgnoreUrls.split(",")));
        }
        return urls;
    }
    
    
    
    public Map<String,String> getAllIgnoreMap(){
        Map<String,String> map = new HashMap<String,String>();
        List<String> all = getSwaggerIgnoreUrlList();
        all.addAll(getDruidIgnoreUrlList());
        all.addAll(getCommonIgnoreUrlList());
        if(CollectionUtils.isNotEmpty(all)){
            for(String url:all){
                map.put(url, url);
            }
        }
        return map;
    }

}
