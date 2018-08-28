package com.sensenets.sinopec.buiness.condition;

import java.util.List;

import com.sensenets.sinopec.common.domain.SortObj;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 18:42
 * @desc 通用查询条件
 */
@Data
public class CommonCondition  {

    @ApiModelProperty(value = "是否分页")
    private boolean isPage = false;

    @ApiModelProperty(value = "请求时间戳")
    private long timestamp = System.currentTimeMillis();
    
    @ApiModelProperty(value = "当前页码")
    private int pageNumber = 1;

    @ApiModelProperty(value = "每页记录数")
    private int pageSize = 10;
    
    @ApiModelProperty(value = "排序字段列表")
    private List<SortObj> sortList;
    

}
