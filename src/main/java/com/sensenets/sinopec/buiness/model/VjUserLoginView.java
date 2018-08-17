/**
  * VjUserLoginView.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;

/**
 * @Title vj_user_login_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 18:41:04
 */
public class VjUserLoginView implements Serializable {
    /**
     * @Fields userId 
     */
    private String userId;

    /**
     * @Fields userName 
     */
    private String userName;

    /**
     * @Fields userType 
     */
    private Short userType;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields realName 
     */
    private String realName;

    /**
     * @Fields pwd 
     */
    private String pwd;

    /**
     * @Fields enable 
     */
    private Short enable;

    /**
     * @Fields funcRoleId 
     */
    private String funcRoleId;

    /**
     * @Fields funcRoleStatus 
     */
    private Short funcRoleStatus;

    /**
     * @Fields funcRoleType 
     */
    private Short funcRoleType;

    /**
     * @Fields sensorRoleId 
     */
    private String sensorRoleId;

    /**
     * @Fields sensorRoleStatus 
     */
    private Short sensorRoleStatus;

    /**
     * @Fields sensorRoleType 
     */
    private Short sensorRoleType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:vj_user_login_view.user_id
     *
     * @return vj_user_login_view.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:vj_user_login_view.user_id
     *
     * @param userId the value for vj_user_login_view.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:vj_user_login_view.user_name
     *
     * @return vj_user_login_view.user_name, 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置  字段:vj_user_login_view.user_name
     *
     * @param userName the value for vj_user_login_view.user_name, 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取  字段:vj_user_login_view.user_type
     *
     * @return vj_user_login_view.user_type, 
     */
    public Short getUserType() {
        return userType;
    }

    /**
     * 设置  字段:vj_user_login_view.user_type
     *
     * @param userType the value for vj_user_login_view.user_type, 
     */
    public void setUserType(Short userType) {
        this.userType = userType;
    }

    /**
     * 获取  字段:vj_user_login_view.status
     *
     * @return vj_user_login_view.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:vj_user_login_view.status
     *
     * @param status the value for vj_user_login_view.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:vj_user_login_view.real_name
     *
     * @return vj_user_login_view.real_name, 
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置  字段:vj_user_login_view.real_name
     *
     * @param realName the value for vj_user_login_view.real_name, 
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取  字段:vj_user_login_view.pwd
     *
     * @return vj_user_login_view.pwd, 
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置  字段:vj_user_login_view.pwd
     *
     * @param pwd the value for vj_user_login_view.pwd, 
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取  字段:vj_user_login_view.enable
     *
     * @return vj_user_login_view.enable, 
     */
    public Short getEnable() {
        return enable;
    }

    /**
     * 设置  字段:vj_user_login_view.enable
     *
     * @param enable the value for vj_user_login_view.enable, 
     */
    public void setEnable(Short enable) {
        this.enable = enable;
    }

    /**
     * 获取  字段:vj_user_login_view.func_role_id
     *
     * @return vj_user_login_view.func_role_id, 
     */
    public String getFuncRoleId() {
        return funcRoleId;
    }

    /**
     * 设置  字段:vj_user_login_view.func_role_id
     *
     * @param funcRoleId the value for vj_user_login_view.func_role_id, 
     */
    public void setFuncRoleId(String funcRoleId) {
        this.funcRoleId = funcRoleId;
    }

    /**
     * 获取  字段:vj_user_login_view.func_role_status
     *
     * @return vj_user_login_view.func_role_status, 
     */
    public Short getFuncRoleStatus() {
        return funcRoleStatus;
    }

    /**
     * 设置  字段:vj_user_login_view.func_role_status
     *
     * @param funcRoleStatus the value for vj_user_login_view.func_role_status, 
     */
    public void setFuncRoleStatus(Short funcRoleStatus) {
        this.funcRoleStatus = funcRoleStatus;
    }

    /**
     * 获取  字段:vj_user_login_view.func_role_type
     *
     * @return vj_user_login_view.func_role_type, 
     */
    public Short getFuncRoleType() {
        return funcRoleType;
    }

    /**
     * 设置  字段:vj_user_login_view.func_role_type
     *
     * @param funcRoleType the value for vj_user_login_view.func_role_type, 
     */
    public void setFuncRoleType(Short funcRoleType) {
        this.funcRoleType = funcRoleType;
    }

    /**
     * 获取  字段:vj_user_login_view.sensor_role_id
     *
     * @return vj_user_login_view.sensor_role_id, 
     */
    public String getSensorRoleId() {
        return sensorRoleId;
    }

    /**
     * 设置  字段:vj_user_login_view.sensor_role_id
     *
     * @param sensorRoleId the value for vj_user_login_view.sensor_role_id, 
     */
    public void setSensorRoleId(String sensorRoleId) {
        this.sensorRoleId = sensorRoleId;
    }

    /**
     * 获取  字段:vj_user_login_view.sensor_role_status
     *
     * @return vj_user_login_view.sensor_role_status, 
     */
    public Short getSensorRoleStatus() {
        return sensorRoleStatus;
    }

    /**
     * 设置  字段:vj_user_login_view.sensor_role_status
     *
     * @param sensorRoleStatus the value for vj_user_login_view.sensor_role_status, 
     */
    public void setSensorRoleStatus(Short sensorRoleStatus) {
        this.sensorRoleStatus = sensorRoleStatus;
    }

    /**
     * 获取  字段:vj_user_login_view.sensor_role_type
     *
     * @return vj_user_login_view.sensor_role_type, 
     */
    public Short getSensorRoleType() {
        return sensorRoleType;
    }

    /**
     * 设置  字段:vj_user_login_view.sensor_role_type
     *
     * @param sensorRoleType the value for vj_user_login_view.sensor_role_type, 
     */
    public void setSensorRoleType(Short sensorRoleType) {
        this.sensorRoleType = sensorRoleType;
    }
}