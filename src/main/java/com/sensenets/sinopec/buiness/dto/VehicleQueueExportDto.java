package com.sensenets.sinopec.buiness.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "VehicleQueueExportDto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleQueueExportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;
    
    @ApiModelProperty(value = "油站名称")
    private String oilStationRepoName;
    

    @ApiModelProperty(value = "进站时间")
    private String inTime;
   
    @ApiModelProperty(value = "进站设备名称")
    private String inSensorName;
    
    @ApiModelProperty(value = "出站时间")
    private String outTime;
    
    @ApiModelProperty(value = "出站设备名称")
    private String outSensorName;
    
    @ApiModelProperty(value = "排队时间")
    private Long queueTime;
    
    @ApiModelProperty(value = "燃油类型")
    private String oilType;
  
    @ApiModelProperty(value = "车辆品牌")
    private String inBrandName;
    
    @ApiModelProperty(value = "车辆类型")
    private String inVehicleTypeName;
    
    @ApiModelProperty(value = "车辆颜色")
    private String inVehicleColorName;
    
    @ApiModelProperty(value = "车牌类型")
    private String inPlateType;
    
    @ApiModelProperty(value = "车牌颜色")
    private String inPlateColor;
    
    @ApiModelProperty(value = "车牌号码")
    private String inPlateNumber;
    
    @ApiModelProperty(value = "车辆角度")
    private String inVehicleAngleName;
    
    
    @ApiModelProperty(value = "车辆品牌")
    private String outBrandName;
    
    @ApiModelProperty(value = "车辆类型")
    private String outVehicleTypeName;
    
    @ApiModelProperty(value = "车辆颜色")
    private String outVehicleColorName;
    
    @ApiModelProperty(value = "车牌类型")
    private String outPlateType;
    
    @ApiModelProperty(value = "车牌颜色")
    private String outPlateColor;
    
    @ApiModelProperty(value = "车牌号码")
    private String outPlateNumber;
    
    @ApiModelProperty(value = "车辆角度")
    private String outVehicleAngleName;
  
    
    @ApiModelProperty(value = "进站高清原图")
    private String inSourceImage;
    
    @ApiModelProperty(value = "进站特征图")
    private String inFeatureImage;
    
    @ApiModelProperty(value = "出站高清原图")
    private String outSourceImage;
    
    @ApiModelProperty(value = "出站特征图")
    private String outFeatureImage;
    

}