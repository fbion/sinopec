/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月18日 上午11:47:17
 * @version V1.0
 */
package com.sensenets.sinopec.common.startup;

import dg.model.PimpObject;
import dg.model.PimpOilEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
  * @ClassName: SystemRunner
  * @Description: 在spring boot容器启动完成后启动（其他的ApplicationRunner也可以实现该功能）
  * @author think
  * @date 2018年8月18日 上午11:47:17
  */
@Component
@Slf4j
@Order(-1)
public class SystemInitRunner implements CommandLineRunner{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.faceTopic}")
    private String faceTopic;

    @Override
    public void run(String... args) throws Exception {
        test();
        log.info("程序启动完成");
    }

    public void test(){
        PimpOilEvent.OilEvent oilEvent = PimpOilEvent.OilEvent.newBuilder()
                .setEventId("11111")
                .setAmount(111.00f)
                .setOilCardId("沃尔沃二")
                .build();
        PimpObject.ObjectPublish objectPublish  =  PimpObject.ObjectPublish.newBuilder()
                .setObjectType(PimpObject.ObjectType.Object_Type_Oil_Event)
                .setBinData(oilEvent.toByteString())
                .build();
        objectPublish.toByteString();

        kafkaTemplate.send(faceTopic,objectPublish);


    }

}
