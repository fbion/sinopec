
package com.sensenets.sinopec.kafka.common;

import java.nio.ByteBuffer;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueDataDto;
import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueDataHelper;
import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueSourceData;
import com.sensenets.sinopec.kafka.core.DataCategory;
import com.sensenets.sinopec.kafka.core.ExchangeMessageHandler;

import lombok.Data;


/**
  * @ClassName: KafkaReceiveMessageHandler
  * @Description: kafka接收到的原始数据格式化后插入数据库
  * @author think
  * @date 2018年9月10日 下午5:40:50
  *
  */
@Component(value = "kafkaReceiveMessageHandler")
@Data
public class KafkaReceive2BufferHandler extends ExchangeMessageHandler{

    @Override
    public void push(DataCategory category, VehicleQueueSourceData data) throws Exception {
        switch (category) {
        case GAS_STATION:
            List<VehicleQueueSourceData> list = Lists.newArrayList();
            list.add(data);
            VehicleQueueDataHelper.producerData(new VehicleQueueDataDto(list));
            break;
        default:
            break;
        }
    }

    
    @Override
    public void push(DataCategory var1, ByteBuffer var2) throws Exception {
    }

   
    @Override
    public void push(DataCategory var1, List<ByteBuffer> var2) throws Exception {
    }

}
