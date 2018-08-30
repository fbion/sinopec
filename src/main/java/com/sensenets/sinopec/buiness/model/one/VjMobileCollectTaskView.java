/**
  * VjMobileCollectTaskView.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-29
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.vj_mobile_collect_task_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-29 20:23:32
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value ="VjMobileCollectTaskView")
@Data
public class VjMobileCollectTaskView implements Serializable {
    /**
     * @Fields id 
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * @Fields collectRepoId 
     */
    @ApiModelProperty(value = "")
    private String collectRepoId;

    /**
     * @Fields oilStationRepoId 
     */
    @ApiModelProperty(value = "")
    private String oilStationRepoId;

    /**
     * @Fields collectStartTime 
     */
    @ApiModelProperty(value = "")
    private Date collectStartTime;

    /**
     * @Fields collectEndTime 
     */
    @ApiModelProperty(value = "")
    private Date collectEndTime;

    /**
     * @Fields type 
     */
    @ApiModelProperty(value = "")
    private Short type;

    /**
     * @Fields userId 
     */
    @ApiModelProperty(value = "")
    private String userId;

    /**
     * @Fields uts 
     */
    @ApiModelProperty(value = "")
    private Date uts;

    /**
     * @Fields taskStatus 
     */
    @ApiModelProperty(value = "")
    private Short taskStatus;

    /**
     * @Fields status 
     */
    @ApiModelProperty(value = "")
    private Short status;

    /**
     * @Fields raRepoIdId 
     */
    @ApiModelProperty(value = "")
    private String raRepoIdId;

    /**
     * @Fields raRepoName 
     */
    @ApiModelProperty(value = "")
    private String raRepoName;

    /**
     * @Fields raParentId 
     */
    @ApiModelProperty(value = "")
    private String raParentId;

    /**
     * @Fields rbRepoId 
     */
    @ApiModelProperty(value = "")
    private String rbRepoId;

    /**
     * @Fields rbRepoName 
     */
    @ApiModelProperty(value = "")
    private String rbRepoName;

    /**
     * @Fields rbParentId 
     */
    @ApiModelProperty(value = "")
    private String rbParentId;

    /**
     * @Fields collectRpath 
     */
    @ApiModelProperty(value = "")
    private Long[]  collectRpath;

    /**
     * @Fields stationRpath 
     */
    @ApiModelProperty(value = "")
    private Long[]  stationRpath;

    private static final long serialVersionUID = 1L;

   
}