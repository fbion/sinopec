/**
  * MobileCollectTask.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-29
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.mobile_collect_task表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-29 19:43:33
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value ="MobileCollectTask")
@Data
public class MobileCollectTask implements Serializable {
    /**
     * @Fields id 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * @Fields collectRepoId 采集的设备id
     */
    @ApiModelProperty(value = "采集的设备id")
    private String collectRepoId;

    /**
     * @Fields oilStationRepoId 油站id
     */
    @ApiModelProperty(value = "油站id")
    private String oilStationRepoId;

    /**
     * @Fields collectStartTime 采集开始时间
     */
    @ApiModelProperty(value = "采集开始时间")
    private Date collectStartTime;

    /**
     * @Fields collectEndTime 采集结束时间
     */
    @ApiModelProperty(value = "采集结束时间")
    private Date collectEndTime;

    /**
     * @Fields type 分析类型（1.进/出站流量2.站外流量3全部）
     */
    @ApiModelProperty(value = "分析类型（1.进/出站流量2.站外流量3全部）")
    private Short type;

    /**
     * @Fields uts 添加时间戳
     */
    @ApiModelProperty(value = "添加时间戳")
    private Date uts;

    /**
     * @Fields ts 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private Long ts;

    /**
     * @Fields userId 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * @Fields taskStatus 任务类型(1.正在分析,2.分析完成)
     */
    @ApiModelProperty(value = "任务类型(1.正在分析,2.分析完成)")
    private Short taskStatus;

    /**
     * @Fields status 状态(1正常   4 删除)
     */
    @ApiModelProperty(value = "状态(1正常   4 删除)")
    private Short status;

    private static final long serialVersionUID = 1L;

    
}