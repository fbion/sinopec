package com.sensenets.sinopec.buiness.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import dg.model.PimpObject;
import dg.model.PimpOilEvent;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


/**
  * @ClassName: KafkaConsumer
  * @Description: 消息消费者
  * @author think
  * @date 2018年8月10日 下午2:38:36
  *
  */
@Component
@Slf4j
public class KafkaReceiver {

    
    @KafkaListener(topics = {"${kafka.faceTopic}"})
    public void processFaceMsg(PimpObject.ObjectPublish content) {
        PimpObject.ObjectPublish obj  = content;
        switch (obj.getObjectTypeValue()){
        case PimpObject.ObjectType.Object_Type_Oil_Event_VALUE:
            try {
                PimpOilEvent.OilEvent event =  PimpOilEvent.OilEvent.parseFrom(obj.getBinData());
                log.info("接收人脸消息:" + event.getEventId());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            break;
            default:
                break;
        }


    }
    

    @KafkaListener(topics = {"${kafka.vehicleTopic}"})
    public void processVehicleMsg(String content) {
        log.info("接收车消息：" + content);
    }
}
