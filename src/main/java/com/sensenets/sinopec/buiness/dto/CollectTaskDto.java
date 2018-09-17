/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月29日 下午5:45:01
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.dto;

import java.util.Date;
import java.util.List;

import com.sensenets.sinopec.buiness.model.two.CollectResultFlow;
import com.sensenets.sinopec.buiness.model.two.CollectResultType;
import com.sensenets.sinopec.common.enums.ResultTypeEnum;

import lombok.Data;

/**
  * @ClassName: CollectTaskDto
  * @Description: 采集任务对象
  * @author think
  * @date 2018年8月29日 下午5:45:01
  *
  */
@Data
public class CollectTaskDto {

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = -9003825328183024867L;

    private boolean sendOk;
    
    /**
     * @Fields id 主键
     */
    private Long id;

    /**
     * @Fields collectRepoId 采集的设备id
     */
    private String collectRepoId;
   
    
    /**
      * @Fields collectParent : 采集组织id
      */
    private Long collectId;


    /**
     * @Fields oilStationRepoId 油站id
     */
    private String oilStationRepoId;

   
    
    /**
      * @Fields oilStationParent : 油站组织id
      */
    private Long oilStationId;

    /**
     * @Fields collectStartTime 采集开始时间
     */
    private Date collectStartTime;

    /**
     * @Fields collectEndTime 采集结束时间
     */
    private Date collectEndTime;

    /**
     * @Fields type 分析类型（1.进站流量2.站外流量3.全部）
     */
    private Short type;

    /**
     * @Fields taskStatus 任务状态(1.正在分析,2.分析完成)
     */
    private Short taskStatus;
    
    /**
      * @Fields sensorInIds : 关联的采集设备进站
      */
    private List<Long> sensorCollectInIds;
    
    /**
      * @Fields sensorCollectOutIds : 关联的采集设备站外
      */
    private List<Long> sensorCollectOutIds;
    
    /**
     * @Fields sensorInIds : 关联的进站摄像机
     */
    private List<Long> sensorInIds;
    
    /**
     * @Fields sensorOutIds : 关联的出站摄像机
     */
    private List<Long> sensorOutIds;
    
    /**
      * @Fields resultFlowId : 统计结果id
      */
    private Long resultId;
    
    private ResultTypeEnum resultType;
    
    private CollectResultFlow collectResultFlow;
    
    private CollectResultType collectResultType;
    
    
}
