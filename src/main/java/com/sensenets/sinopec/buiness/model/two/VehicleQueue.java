/**
  * VehicleQueue.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-03
  */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.vehicle_queue表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-03 17:29:18
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value ="VehicleQueue")
@Data
public class VehicleQueue implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * @Fields id 
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * @Fields bizId 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private String bizId;

    /**
     * @Fields vehicleInId 进站车辆id
     */
    @ApiModelProperty(value = "进站车辆id")
    private String vehicleInId;

    /**
     * @Fields vehicleOutId 出站车辆id
     */
    @ApiModelProperty(value = "出站车辆id")
    private String vehicleOutId;

    /**
     * @Fields uts 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date uts;

 

    
}