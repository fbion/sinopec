/**
  * VjFuncRoleUrlView.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-17
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;

/**
 * @Title vj_func_role_url_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-17 12:00:32
 */
public class VjFuncRoleUrlView implements Serializable {
    /**
     * @Fields funcId 
     */
    private String funcId;

    /**
     * @Fields funcUri 
     */
    private String funcUri;

    /**
     * @Fields funcName 
     */
    private String funcName;

    /**
     * @Fields funcStatus 
     */
    private Short funcStatus;

    /**
     * @Fields funcRoleId 
     */
    private String funcRoleId;

    /**
     * @Fields funcRoleFuncsStatus 
     */
    private Short funcRoleFuncsStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:vj_func_role_url_view.func_id
     *
     * @return vj_func_role_url_view.func_id, 
     */
    public String getFuncId() {
        return funcId;
    }

    /**
     * 设置  字段:vj_func_role_url_view.func_id
     *
     * @param funcId the value for vj_func_role_url_view.func_id, 
     */
    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    /**
     * 获取  字段:vj_func_role_url_view.func_uri
     *
     * @return vj_func_role_url_view.func_uri, 
     */
    public String getFuncUri() {
        return funcUri;
    }

    /**
     * 设置  字段:vj_func_role_url_view.func_uri
     *
     * @param funcUri the value for vj_func_role_url_view.func_uri, 
     */
    public void setFuncUri(String funcUri) {
        this.funcUri = funcUri;
    }

    /**
     * 获取  字段:vj_func_role_url_view.func_name
     *
     * @return vj_func_role_url_view.func_name, 
     */
    public String getFuncName() {
        return funcName;
    }

    /**
     * 设置  字段:vj_func_role_url_view.func_name
     *
     * @param funcName the value for vj_func_role_url_view.func_name, 
     */
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    /**
     * 获取  字段:vj_func_role_url_view.func_status
     *
     * @return vj_func_role_url_view.func_status, 
     */
    public Short getFuncStatus() {
        return funcStatus;
    }

    /**
     * 设置  字段:vj_func_role_url_view.func_status
     *
     * @param funcStatus the value for vj_func_role_url_view.func_status, 
     */
    public void setFuncStatus(Short funcStatus) {
        this.funcStatus = funcStatus;
    }

    /**
     * 获取  字段:vj_func_role_url_view.func_role_id
     *
     * @return vj_func_role_url_view.func_role_id, 
     */
    public String getFuncRoleId() {
        return funcRoleId;
    }

    /**
     * 设置  字段:vj_func_role_url_view.func_role_id
     *
     * @param funcRoleId the value for vj_func_role_url_view.func_role_id, 
     */
    public void setFuncRoleId(String funcRoleId) {
        this.funcRoleId = funcRoleId;
    }

    /**
     * 获取  字段:vj_func_role_url_view.func_role_funcs_status
     *
     * @return vj_func_role_url_view.func_role_funcs_status, 
     */
    public Short getFuncRoleFuncsStatus() {
        return funcRoleFuncsStatus;
    }

    /**
     * 设置  字段:vj_func_role_url_view.func_role_funcs_status
     *
     * @param funcRoleFuncsStatus the value for vj_func_role_url_view.func_role_funcs_status, 
     */
    public void setFuncRoleFuncsStatus(Short funcRoleFuncsStatus) {
        this.funcRoleFuncsStatus = funcRoleFuncsStatus;
    }
}