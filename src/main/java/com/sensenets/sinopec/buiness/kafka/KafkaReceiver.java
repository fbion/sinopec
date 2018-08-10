package com.sensenets.sinopec.buiness.kafka;

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
    public void processFaceMsg(String content) {
        log.info("接收人脸消息:" + content);
    }
    

    @KafkaListener(topics = {"${kafka.vehicleTopic}"})
    public void processVehicleMsg(String content) {
        log.info("接收车消息：" + content);
    }
}
