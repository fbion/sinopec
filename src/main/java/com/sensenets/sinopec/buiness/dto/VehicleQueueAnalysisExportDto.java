package com.sensenets.sinopec.buiness.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "VehicleQueueAnalysisExportDto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleQueueAnalysisExportDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "油站")
    private String oilStationRepoName;

    @ApiModelProperty(value = "进站时间")
    private String inTime;
   
    @ApiModelProperty(value = "出站时间")
    private String outTime;
    
    @ApiModelProperty(value = "排队时间")
    private Long queueTime;
    
    @ApiModelProperty(value = "燃油类型")
    private String oilType;
  
    @ApiModelProperty(value = "车型")
    private String vehicleTypeName;
    
    @ApiModelProperty(value = "车身颜色")
    private String vehicleColorName;
    
    @ApiModelProperty(value = "车牌类型")
    private String plateType;
    
    @ApiModelProperty(value = "车牌颜色")
    private String plateColor;
    
    @ApiModelProperty(value = "车牌")
    private String plateNumber;

}