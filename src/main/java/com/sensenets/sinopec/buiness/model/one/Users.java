/**
  * Users.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title users表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:15:22
 */
public class Users implements Serializable {
    /**
     * @Fields userId 
     */
    private String userId;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields userName 
     */
    private String userName;

    /**
     * @Fields repoId 
     */
    private String repoId;

    /**
     * @Fields userType 
     */
    private Short userType;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields realName 真实用户名
     */
    private String realName;

    /**
     * @Fields pwd 密码
     */
    private String pwd;

    /**
     * @Fields comment 
     */
    private String comment;

    /**
     * @Fields enable 1:启用，2:禁用
     */
    private Short enable;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:users.user_id
     *
     * @return users.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:users.user_id
     *
     * @param userId the value for users.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:users.uts
     *
     * @return users.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:users.uts
     *
     * @param uts the value for users.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:users.user_name
     *
     * @return users.user_name, 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置  字段:users.user_name
     *
     * @param userName the value for users.user_name, 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取  字段:users.repo_id
     *
     * @return users.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:users.repo_id
     *
     * @param repoId the value for users.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:users.user_type
     *
     * @return users.user_type, 
     */
    public Short getUserType() {
        return userType;
    }

    /**
     * 设置  字段:users.user_type
     *
     * @param userType the value for users.user_type, 
     */
    public void setUserType(Short userType) {
        this.userType = userType;
    }

    /**
     * 获取  字段:users.status
     *
     * @return users.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:users.status
     *
     * @param status the value for users.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取 真实用户名 字段:users.real_name
     *
     * @return users.real_name, 真实用户名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置 真实用户名 字段:users.real_name
     *
     * @param realName the value for users.real_name, 真实用户名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取 密码 字段:users.pwd
     *
     * @return users.pwd, 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置 密码 字段:users.pwd
     *
     * @param pwd the value for users.pwd, 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取  字段:users.comment
     *
     * @return users.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:users.comment
     *
     * @param comment the value for users.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取 1:启用，2:禁用 字段:users.enable
     *
     * @return users.enable, 1:启用，2:禁用
     */
    public Short getEnable() {
        return enable;
    }

    /**
     * 设置 1:启用，2:禁用 字段:users.enable
     *
     * @param enable the value for users.enable, 1:启用，2:禁用
     */
    public void setEnable(Short enable) {
        this.enable = enable;
    }
}