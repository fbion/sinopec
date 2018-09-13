package com.sensenets.sinopec.kafka.buffer.gas;
import java.io.Serializable;
import java.util.List;

import lombok.Data;


/**
  * @ClassName: VehicleQueueDataDto
  * @Description: 接收到的油站原始车辆数据
  * @author think
  * @date 2018年9月10日 下午6:21:01
  *
  */
@Data
public class VehicleQueueDataDto  implements Serializable{
    
    private static final long serialVersionUID = -2508331359246772314L;
    
    private List<VehicleQueueSourceData> list;
    
    public VehicleQueueDataDto(){
        
    }
    
    public VehicleQueueDataDto(List<VehicleQueueSourceData> list){
        this.list = list;
    }
    
}
