/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月27日 上午10:29:21
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
  * @ClassName: MobileCollectTaskCriteria
  * @Description: 移动数据采集查询条件
  * @author think
  * @date 2018年8月27日 上午10:29:21
  *
  */
@Data
@ApiModel(description="移动数据采集查询条件",value ="MobileCollectTaskCondition")
public class MobileCollectTaskCondition extends CommonCondition{
    
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
    private String collectStartTime;

    /**
     * @Fields collectEndTime 采集结束时间
     */
    @ApiModelProperty(value = "采集结束时间")
    private String collectEndTime;

    /**
     * @Fields type 分析类型（1.进/出站流量2.站外流量）
     */
    @ApiModelProperty(value = "分析类型（1.进/出站流量2.站外流量）")
    private Short type;

    public static void main(String[] args) {
        double wuye = 1.5*114*12 ;
        System.out.println("每年物业费用："+wuye);
        double qingyun = 3*114 ;
        System.out.println("垃圾清运费用："+qingyun);
        System.out.println("交房总费用："+(2000+qingyun+wuye));
        System.out.println(System.currentTimeMillis());
    }

}
