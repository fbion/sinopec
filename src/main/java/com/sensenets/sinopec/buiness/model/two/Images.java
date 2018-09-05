/**
  * Images.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-05
  */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.images表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-05 14:00:11
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="Images")
public class Images implements Serializable {
    /**
     * @Fields imageId 
     */
    @ApiModelProperty(value = "")
    private String imageId;

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
     * @Fields ts 
     */
    @ApiModelProperty(value = "")
    private Long ts;

    /**
     * @Fields repoId 
     */
    @ApiModelProperty(value = "")
    private String repoId;

    /**
     * @Fields sensorId 
     */
    @ApiModelProperty(value = "")
    private String sensorId;

    /**
     * @Fields sourceId 
     */
    @ApiModelProperty(value = "")
    private String sourceId;

    /**
     * @Fields taskId 
     */
    @ApiModelProperty(value = "")
    private String taskId;

    /**
     * @Fields userId 
     */
    @ApiModelProperty(value = "")
    private String userId;

    /**
     * @Fields type 
     */
    @ApiModelProperty(value = "")
    private Short type;

    /**
     * @Fields imageUri 
     */
    @ApiModelProperty(value = "")
    private String imageUri;

    /**
     * @Fields width 
     */
    @ApiModelProperty(value = "")
    private Integer width;

    /**
     * @Fields height 
     */
    @ApiModelProperty(value = "")
    private Integer height;

    /**
     * @Fields thumbnailImageUri 
     */
    @ApiModelProperty(value = "")
    private String thumbnailImageUri;

    /**
     * @Fields thumbnailWidth 
     */
    @ApiModelProperty(value = "")
    private Integer thumbnailWidth;

    /**
     * @Fields thumbnailHeight 
     */
    @ApiModelProperty(value = "")
    private Integer thumbnailHeight;

    /**
     * @Fields status 
     */
    @ApiModelProperty(value = "")
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:public.images.image_id
     *
     * @return public.images.image_id, 
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * 设置  字段:public.images.image_id
     *
     * @param imageId the value for public.images.image_id, 
     */
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    /**
     * 获取  字段:public.images.id
     *
     * @return public.images.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:public.images.id
     *
     * @param id the value for public.images.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:public.images.uts
     *
     * @return public.images.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:public.images.uts
     *
     * @param uts the value for public.images.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:public.images.ts
     *
     * @return public.images.ts, 
     */
    public Long getTs() {
        return ts;
    }

    /**
     * 设置  字段:public.images.ts
     *
     * @param ts the value for public.images.ts, 
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     * 获取  字段:public.images.repo_id
     *
     * @return public.images.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:public.images.repo_id
     *
     * @param repoId the value for public.images.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:public.images.sensor_id
     *
     * @return public.images.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:public.images.sensor_id
     *
     * @param sensorId the value for public.images.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:public.images.source_id
     *
     * @return public.images.source_id, 
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置  字段:public.images.source_id
     *
     * @param sourceId the value for public.images.source_id, 
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取  字段:public.images.task_id
     *
     * @return public.images.task_id, 
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置  字段:public.images.task_id
     *
     * @param taskId the value for public.images.task_id, 
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取  字段:public.images.user_id
     *
     * @return public.images.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:public.images.user_id
     *
     * @param userId the value for public.images.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:public.images.type
     *
     * @return public.images.type, 
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置  字段:public.images.type
     *
     * @param type the value for public.images.type, 
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取  字段:public.images.image_uri
     *
     * @return public.images.image_uri, 
     */
    public String getImageUri() {
        return imageUri;
    }

    /**
     * 设置  字段:public.images.image_uri
     *
     * @param imageUri the value for public.images.image_uri, 
     */
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    /**
     * 获取  字段:public.images.width
     *
     * @return public.images.width, 
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 设置  字段:public.images.width
     *
     * @param width the value for public.images.width, 
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 获取  字段:public.images.height
     *
     * @return public.images.height, 
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 设置  字段:public.images.height
     *
     * @param height the value for public.images.height, 
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 获取  字段:public.images.thumbnail_image_uri
     *
     * @return public.images.thumbnail_image_uri, 
     */
    public String getThumbnailImageUri() {
        return thumbnailImageUri;
    }

    /**
     * 设置  字段:public.images.thumbnail_image_uri
     *
     * @param thumbnailImageUri the value for public.images.thumbnail_image_uri, 
     */
    public void setThumbnailImageUri(String thumbnailImageUri) {
        this.thumbnailImageUri = thumbnailImageUri;
    }

    /**
     * 获取  字段:public.images.thumbnail_width
     *
     * @return public.images.thumbnail_width, 
     */
    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * 设置  字段:public.images.thumbnail_width
     *
     * @param thumbnailWidth the value for public.images.thumbnail_width, 
     */
    public void setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    /**
     * 获取  字段:public.images.thumbnail_height
     *
     * @return public.images.thumbnail_height, 
     */
    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    /**
     * 设置  字段:public.images.thumbnail_height
     *
     * @param thumbnailHeight the value for public.images.thumbnail_height, 
     */
    public void setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    /**
     * 获取  字段:public.images.status
     *
     * @return public.images.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:public.images.status
     *
     * @param status the value for public.images.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}