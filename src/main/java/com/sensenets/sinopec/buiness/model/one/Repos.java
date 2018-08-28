/**
  * Repos.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-28
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.repos表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-28 16:28:34
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="Repos")
public class Repos implements Serializable {
    /**
     * @Fields repoId 
     */
    @ApiModelProperty(value = "")
    private String repoId;

    /**
     * @Fields id 
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * @Fields uts 
     */
    @ApiModelProperty(value = "")
    private Date uts;

    /**
     * @Fields repoName 
     */
    @ApiModelProperty(value = "")
    private String repoName;

    /**
     * @Fields type 
     */
    @ApiModelProperty(value = "")
    private Short type;

    /**
     * @Fields repoSn 区域代码
     */
    @ApiModelProperty(value = "区域代码")
    private String repoSn;

    /**
     * @Fields repoLevel 行政级别
     */
    @ApiModelProperty(value = "行政级别")
    private Short repoLevel;

    /**
     * @Fields levelId 
     */
    @ApiModelProperty(value = "")
    private Short levelId;

    /**
     * @Fields parentId 
     */
    @ApiModelProperty(value = "")
    private String parentId;

    /**
     * @Fields leftId 
     */
    @ApiModelProperty(value = "")
    private String leftId;

    /**
     * @Fields rightId 
     */
    @ApiModelProperty(value = "")
    private String rightId;

    /**
     * @Fields comment 
     */
    @ApiModelProperty(value = "")
    private String comment;

    /**
     * @Fields status 
     */
    @ApiModelProperty(value = "")
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:public.repos.repo_id
     *
     * @return public.repos.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:public.repos.repo_id
     *
     * @param repoId the value for public.repos.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:public.repos.id
     *
     * @return public.repos.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:public.repos.id
     *
     * @param id the value for public.repos.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:public.repos.uts
     *
     * @return public.repos.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:public.repos.uts
     *
     * @param uts the value for public.repos.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:public.repos.repo_name
     *
     * @return public.repos.repo_name, 
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * 设置  字段:public.repos.repo_name
     *
     * @param repoName the value for public.repos.repo_name, 
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * 获取  字段:public.repos.type
     *
     * @return public.repos.type, 
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置  字段:public.repos.type
     *
     * @param type the value for public.repos.type, 
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取 区域代码 字段:public.repos.repo_sn
     *
     * @return public.repos.repo_sn, 区域代码
     */
    public String getRepoSn() {
        return repoSn;
    }

    /**
     * 设置 区域代码 字段:public.repos.repo_sn
     *
     * @param repoSn the value for public.repos.repo_sn, 区域代码
     */
    public void setRepoSn(String repoSn) {
        this.repoSn = repoSn;
    }

    /**
     * 获取 行政级别 字段:public.repos.repo_level
     *
     * @return public.repos.repo_level, 行政级别
     */
    public Short getRepoLevel() {
        return repoLevel;
    }

    /**
     * 设置 行政级别 字段:public.repos.repo_level
     *
     * @param repoLevel the value for public.repos.repo_level, 行政级别
     */
    public void setRepoLevel(Short repoLevel) {
        this.repoLevel = repoLevel;
    }

    /**
     * 获取  字段:public.repos.level_id
     *
     * @return public.repos.level_id, 
     */
    public Short getLevelId() {
        return levelId;
    }

    /**
     * 设置  字段:public.repos.level_id
     *
     * @param levelId the value for public.repos.level_id, 
     */
    public void setLevelId(Short levelId) {
        this.levelId = levelId;
    }

    /**
     * 获取  字段:public.repos.parent_id
     *
     * @return public.repos.parent_id, 
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置  字段:public.repos.parent_id
     *
     * @param parentId the value for public.repos.parent_id, 
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取  字段:public.repos.left_id
     *
     * @return public.repos.left_id, 
     */
    public String getLeftId() {
        return leftId;
    }

    /**
     * 设置  字段:public.repos.left_id
     *
     * @param leftId the value for public.repos.left_id, 
     */
    public void setLeftId(String leftId) {
        this.leftId = leftId;
    }

    /**
     * 获取  字段:public.repos.right_id
     *
     * @return public.repos.right_id, 
     */
    public String getRightId() {
        return rightId;
    }

    /**
     * 设置  字段:public.repos.right_id
     *
     * @param rightId the value for public.repos.right_id, 
     */
    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    /**
     * 获取  字段:public.repos.comment
     *
     * @return public.repos.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:public.repos.comment
     *
     * @param comment the value for public.repos.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取  字段:public.repos.status
     *
     * @return public.repos.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:public.repos.status
     *
     * @param status the value for public.repos.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}