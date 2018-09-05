package com.sensenets.sinopec.buiness.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="车辆品牌查询对象",value ="BrandObj")
public class BrandObj {

    @ApiModelProperty(value = "主品牌id")
    private Short BrandId;
    

    @ApiModelProperty(value = "子品牌id")
    private Short SubBrandId;

    @ApiModelProperty(value = "车辆年款id")
    private Short ModelYearId;

}