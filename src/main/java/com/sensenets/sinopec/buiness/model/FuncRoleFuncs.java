/**
  * FuncRoleFuncs.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title func_role_funcs表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:05:37
 */
public class FuncRoleFuncs implements Serializable {
    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields funcRoleId 
     */
    private String funcRoleId;

    /**
     * @Fields funcId 
     */
    private String funcId;

    /**
     * @Fields status 
     */
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:func_role_funcs.id
     *
     * @return func_role_funcs.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:func_role_funcs.id
     *
     * @param id the value for func_role_funcs.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:func_role_funcs.uts
     *
     * @return func_role_funcs.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:func_role_funcs.uts
     *
     * @param uts the value for func_role_funcs.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:func_role_funcs.func_role_id
     *
     * @return func_role_funcs.func_role_id, 
     */
    public String getFuncRoleId() {
        return funcRoleId;
    }

    /**
     * 设置  字段:func_role_funcs.func_role_id
     *
     * @param funcRoleId the value for func_role_funcs.func_role_id, 
     */
    public void setFuncRoleId(String funcRoleId) {
        this.funcRoleId = funcRoleId;
    }

    /**
     * 获取  字段:func_role_funcs.func_id
     *
     * @return func_role_funcs.func_id, 
     */
    public String getFuncId() {
        return funcId;
    }

    /**
     * 设置  字段:func_role_funcs.func_id
     *
     * @param funcId the value for func_role_funcs.func_id, 
     */
    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    /**
     * 获取  字段:func_role_funcs.status
     *
     * @return func_role_funcs.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:func_role_funcs.status
     *
     * @param status the value for func_role_funcs.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}