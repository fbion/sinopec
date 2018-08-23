/**
  * Funcs.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title funcs表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:08:19
 */
public class Funcs implements Serializable {
    /**
     * @Fields funcId 
     */
    private String funcId;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields funcName 
     */
    private String funcName;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields funcUri 功能的路径，带谓词
     */
    private String funcUri;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:funcs.func_id
     *
     * @return funcs.func_id, 
     */
    public String getFuncId() {
        return funcId;
    }

    /**
     * 设置  字段:funcs.func_id
     *
     * @param funcId the value for funcs.func_id, 
     */
    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    /**
     * 获取  字段:funcs.uts
     *
     * @return funcs.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:funcs.uts
     *
     * @param uts the value for funcs.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:funcs.func_name
     *
     * @return funcs.func_name, 
     */
    public String getFuncName() {
        return funcName;
    }

    /**
     * 设置  字段:funcs.func_name
     *
     * @param funcName the value for funcs.func_name, 
     */
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    /**
     * 获取  字段:funcs.status
     *
     * @return funcs.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:funcs.status
     *
     * @param status the value for funcs.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取 功能的路径，带谓词 字段:funcs.func_uri
     *
     * @return funcs.func_uri, 功能的路径，带谓词
     */
    public String getFuncUri() {
        return funcUri;
    }

    /**
     * 设置 功能的路径，带谓词 字段:funcs.func_uri
     *
     * @param funcUri the value for funcs.func_uri, 功能的路径，带谓词
     */
    public void setFuncUri(String funcUri) {
        this.funcUri = funcUri;
    }
}