/**
  * FuncRoles.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title func_roles表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:07:50
 */
public class FuncRoles implements Serializable {
    /**
     * @Fields funcRoleId 
     */
    private String funcRoleId;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields funcRoleName 
     */
    private String funcRoleName;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields comment 
     */
    private String comment;

    /**
     * @Fields createUser 创建人
     */
    private String createUser;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:func_roles.func_role_id
     *
     * @return func_roles.func_role_id, 
     */
    public String getFuncRoleId() {
        return funcRoleId;
    }

    /**
     * 设置  字段:func_roles.func_role_id
     *
     * @param funcRoleId the value for func_roles.func_role_id, 
     */
    public void setFuncRoleId(String funcRoleId) {
        this.funcRoleId = funcRoleId;
    }

    /**
     * 获取  字段:func_roles.uts
     *
     * @return func_roles.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:func_roles.uts
     *
     * @param uts the value for func_roles.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:func_roles.func_role_name
     *
     * @return func_roles.func_role_name, 
     */
    public String getFuncRoleName() {
        return funcRoleName;
    }

    /**
     * 设置  字段:func_roles.func_role_name
     *
     * @param funcRoleName the value for func_roles.func_role_name, 
     */
    public void setFuncRoleName(String funcRoleName) {
        this.funcRoleName = funcRoleName;
    }

    /**
     * 获取  字段:func_roles.status
     *
     * @return func_roles.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:func_roles.status
     *
     * @param status the value for func_roles.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:func_roles.comment
     *
     * @return func_roles.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:func_roles.comment
     *
     * @param comment the value for func_roles.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取 创建人 字段:func_roles.create_user
     *
     * @return func_roles.create_user, 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置 创建人 字段:func_roles.create_user
     *
     * @param createUser the value for func_roles.create_user, 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}