package com.sensenets.sinopec.buiness.model.two;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="Org",description="测试对象")
public class Org {
    
    @ApiModelProperty(value="测试id",name="id")
    private Long id;

    @ApiModelProperty(value="姓名",name="name")
    private String name;

    @ApiModelProperty(value="时间戳",name="uts",example="2018-08-12 12:12:34")
    private Timestamp uts;
}