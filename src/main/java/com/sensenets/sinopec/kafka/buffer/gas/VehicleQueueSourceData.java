/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月10日 下午6:04:08
 * @version V1.0
 */
package com.sensenets.sinopec.kafka.buffer.gas;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
  * @ClassName: VehicleQueueSourceData
  * @Description: 车辆排队原始数据
  * @author think
  * @date 2018年9月10日 下午6:04:08
  *
  */
@Data
public class VehicleQueueSourceData {


    /**
      * @Fields ts : 过车时间
      */
    @ApiModelProperty(value = "过车时间")
    private Long ts;
    
    /**
     * @Fields sensorId 设备id
     */
    @ApiModelProperty(value = "设备id")
    private Long sensorId;

    /**
     * @Fields sensorName 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String sensorName;

    /**
     * @Fields sourceImage 原图
     */
    @ApiModelProperty(value = "原图")
    private String sourceImage;

    /**
     * @Fields featureImage 特征图
     */
    @ApiModelProperty(value = "特征图")
    private String featureImage;

    /**
     * @Fields time 时间
     */
    @ApiModelProperty(value = "进站或出站时间")
    private Date time;
    
    /**
     * @Fields time 时间
     */
    @ApiModelProperty(value = "提枪时间")
    private Date liftGunTime;
    
    /**
     * @Fields time 时间
     */
    @ApiModelProperty(value = "挂枪时间")
    private Date hangGunTime;
  

    /**
     * @Fields brandId 品牌
     */
    @ApiModelProperty(value = "品牌")
    private Short brandId;

    /**
     * @Fields plateColorId 车牌颜色
     */
    @ApiModelProperty(value = "车牌颜色")
    private Short plateColorId;

    /**
     * @Fields plateTypeId 车牌类型
     */
    @ApiModelProperty(value = "车牌类型")
    private Short plateTypeId;

    /**
     * @Fields angleId 车角度
     */
    @ApiModelProperty(value = "车角度")
    private Short angleId;

    /**
     * @Fields colorId 车辆颜色
     */
    @ApiModelProperty(value = "车辆颜色")
    private Short colorId;

    /**
     * @Fields typeId 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    private Short typeId;

    /**
     * @Fields reposId 油站id
     */
    @ApiModelProperty(value = "油站id")
    private Long reposId;

    /**
     * @Fields reposName 油站名称
     */
    @ApiModelProperty(value = "油站名称")
    private String reposName;


    /**
     * @Fields oilType 油品类型
     */
    @ApiModelProperty(value = "油品类型")
    private String oilType;

    /**
     * @Fields subBrandId 子品牌
     */
    @ApiModelProperty(value = "子品牌")
    private Short subBrandId;

    /**
     * @Fields modeYearId 年款
     */
    @ApiModelProperty(value = "年款")
    private Short modeYearId;

    /**
     * @Fields plateText 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String plateText;
   
}
