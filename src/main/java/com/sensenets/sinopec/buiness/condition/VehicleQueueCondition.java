/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月27日 上午10:29:21
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.condition;

import com.sensenets.sinopec.buiness.dto.BrandObj;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
  * @ClassName: VehicleQueueCondition
  * @Description: 车辆排队查询条件
  * @author think
  * @date 2018年8月27日 上午10:29:21
  *
  */
@Data
@ApiModel(description="车辆排队查询条件",value ="VehicleQueueCondition")
public class VehicleQueueCondition extends CommonCondition{
    
  
    @ApiModelProperty(value = "主键")
    private Long id;
   
    @ApiModelProperty(value = "进站开始时间")
    private String inStartTime;

    @ApiModelProperty(value = "进站结束时间")
    private String inEndTime;
    
    @ApiModelProperty(value = "排队开始时间(单位分钟,最大60)")
    private Integer startQueueTime;
    
    @ApiModelProperty(value = "排队结束时间(单位分钟,最大60)")
    private Integer endQueueTime;
  
    @ApiModelProperty(value = "加油类型(汽油,柴油)")
    private String oilType;

    @ApiModelProperty(value = "油站组织id")
    private String repoId;
  
    @ApiModelProperty(value = "车辆品牌")
    private BrandObj[]  brands;
    
    @ApiModelProperty(value = "车辆类型id")
    private Short[] vehicleType;
    
    @ApiModelProperty(value = "车辆颜色id")
    private Short[] vehicleColorType;
    
    @ApiModelProperty(value = "车牌类型id")
    private Short[]  plateType;
    
    @ApiModelProperty(value = "车牌颜色id")
    private Short[]  plateColorType;
    
    @ApiModelProperty(value = "车辆角度id")
    private Short[]  vehicleAngleType;
    
    @ApiModelProperty(value = "车牌号")
    private String  plateNumber;
    

}
