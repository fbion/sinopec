package com.sensenets.sinopec.buiness.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @Title public.mobile_collect_task表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-28 12:24:39
 */

@ApiModel(value ="MobileCollectTaskDto")
@Data
public class MobileCollectTaskDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
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
      * @Fields collectionRepoName : 采集设备名称
      */
    private String collectionRepoName;
    
    /**
      * @Fields collectAeraName : 区名称
      */
    private String collectAeraName;
    
    /**
      * @Fields collectCityName : 城市名称
      */
    private String collectCityName;

    /**
     * @Fields oilStationRepoId 油站id
     */
    @ApiModelProperty(value = "油站id")
    private String oilStationRepoId;
    
    /**
      * @Fields oilStationRepoName : 油站名称
      */
    private String oilStationRepoName;
    
    /**
      * @Fields oilStationCityName : 油站所属城市名称
      */
    private String oilStationCityName;
    
    /**
      * @Fields oilStationManager :  油站所属经营管理部名称
      */
    private String oilStationManager;

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
     * @Fields type 分析类型（1.进/出站流量2.站外流量）
     */
    @ApiModelProperty(value = "分析类型（1.进/出站流量2.站外流量）")
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
     * @Fields taskStatus 任务状态(1.正在分析,2.分析完成)
     */
    @ApiModelProperty(value = "任务状态(1.正在分析,2.分析完成)")
    private Short taskStatus;

    
    
}