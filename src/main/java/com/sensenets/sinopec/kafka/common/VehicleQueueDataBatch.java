/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月11日 下午6:49:26
 * @version V1.0
 */
package com.sensenets.sinopec.kafka.common;

import dg.model.PimpRecObj.PetrolStationObj;
import lombok.Data;

/**
  * @ClassName: VehicleQueueDataBatch
  * @Description: 车辆排队批量对象
  * @author think
  * @date 2018年9月11日 下午6:49:26
  *
  */
@Data
public class VehicleQueueDataBatch  extends KafkaDataBatch<PetrolStationObj>{

    /**
      * @Fields serialVersionUID
      */
    private static final long serialVersionUID = -2965806743673619356L;

    
    public VehicleQueueDataBatch(){
        
    }
    
    public VehicleQueueDataBatch(String uuid,KafkaDataType dataType,KafkaDataFormatType formatType,PetrolStationObj data){
        this.uuid = uuid;
        this.dataType = dataType;
        this.formatType = formatType;
        this.data = data;
    }
    
}
