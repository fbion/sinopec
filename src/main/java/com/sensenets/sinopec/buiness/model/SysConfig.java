/**
  * SysConfig.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title sys_config表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:13:42
 */
public class SysConfig implements Serializable {
    /**
     * @Fields id 
     */
    private Short id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields configKey 配置项
     */
    private String configKey;

    /**
     * @Fields configValue json格式的配置值
     */
    private String configValue;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:sys_config.id
     *
     * @return sys_config.id, 
     */
    public Short getId() {
        return id;
    }

    /**
     * 设置  字段:sys_config.id
     *
     * @param id the value for sys_config.id, 
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 获取  字段:sys_config.uts
     *
     * @return sys_config.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:sys_config.uts
     *
     * @param uts the value for sys_config.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取 配置项 字段:sys_config.config_key
     *
     * @return sys_config.config_key, 配置项
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * 设置 配置项 字段:sys_config.config_key
     *
     * @param configKey the value for sys_config.config_key, 配置项
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * 获取 json格式的配置值 字段:sys_config.config_value
     *
     * @return sys_config.config_value, json格式的配置值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 设置 json格式的配置值 字段:sys_config.config_value
     *
     * @param configValue the value for sys_config.config_value, json格式的配置值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}