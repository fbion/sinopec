/**
  * Repos.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title repos表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:10:11
 */
public class Repos implements Serializable {
    /**
     * @Fields repoId 
     */
    private String repoId;

    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields repoName 
     */
    private String repoName;

    /**
     * @Fields type 
     */
    private Short type;

    /**
     * @Fields repoSn 区域代码
     */
    private String repoSn;

    /**
     * @Fields repoLevel 行政级别
     */
    private Short repoLevel;

    /**
     * @Fields levelId 
     */
    private Short levelId;

    /**
     * @Fields parentId 
     */
    private String parentId;

    /**
     * @Fields leftId 
     */
    private String leftId;

    /**
     * @Fields rightId 
     */
    private String rightId;

    /**
     * @Fields comment 
     */
    private String comment;

    /**
     * @Fields status 
     */
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:repos.repo_id
     *
     * @return repos.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:repos.repo_id
     *
     * @param repoId the value for repos.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:repos.id
     *
     * @return repos.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:repos.id
     *
     * @param id the value for repos.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:repos.uts
     *
     * @return repos.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:repos.uts
     *
     * @param uts the value for repos.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:repos.repo_name
     *
     * @return repos.repo_name, 
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * 设置  字段:repos.repo_name
     *
     * @param repoName the value for repos.repo_name, 
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * 获取  字段:repos.type
     *
     * @return repos.type, 
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置  字段:repos.type
     *
     * @param type the value for repos.type, 
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取 区域代码 字段:repos.repo_sn
     *
     * @return repos.repo_sn, 区域代码
     */
    public String getRepoSn() {
        return repoSn;
    }

    /**
     * 设置 区域代码 字段:repos.repo_sn
     *
     * @param repoSn the value for repos.repo_sn, 区域代码
     */
    public void setRepoSn(String repoSn) {
        this.repoSn = repoSn;
    }

    /**
     * 获取 行政级别 字段:repos.repo_level
     *
     * @return repos.repo_level, 行政级别
     */
    public Short getRepoLevel() {
        return repoLevel;
    }

    /**
     * 设置 行政级别 字段:repos.repo_level
     *
     * @param repoLevel the value for repos.repo_level, 行政级别
     */
    public void setRepoLevel(Short repoLevel) {
        this.repoLevel = repoLevel;
    }

    /**
     * 获取  字段:repos.level_id
     *
     * @return repos.level_id, 
     */
    public Short getLevelId() {
        return levelId;
    }

    /**
     * 设置  字段:repos.level_id
     *
     * @param levelId the value for repos.level_id, 
     */
    public void setLevelId(Short levelId) {
        this.levelId = levelId;
    }

    /**
     * 获取  字段:repos.parent_id
     *
     * @return repos.parent_id, 
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置  字段:repos.parent_id
     *
     * @param parentId the value for repos.parent_id, 
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取  字段:repos.left_id
     *
     * @return repos.left_id, 
     */
    public String getLeftId() {
        return leftId;
    }

    /**
     * 设置  字段:repos.left_id
     *
     * @param leftId the value for repos.left_id, 
     */
    public void setLeftId(String leftId) {
        this.leftId = leftId;
    }

    /**
     * 获取  字段:repos.right_id
     *
     * @return repos.right_id, 
     */
    public String getRightId() {
        return rightId;
    }

    /**
     * 设置  字段:repos.right_id
     *
     * @param rightId the value for repos.right_id, 
     */
    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    /**
     * 获取  字段:repos.comment
     *
     * @return repos.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:repos.comment
     *
     * @param comment the value for repos.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取  字段:repos.status
     *
     * @return repos.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:repos.status
     *
     * @param status the value for repos.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}