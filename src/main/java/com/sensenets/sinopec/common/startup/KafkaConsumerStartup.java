package com.sensenets.sinopec.common.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sensenets.sinopec.kafka.common.KafkaReceiveHandler;
import com.sensenets.sinopec.kafka.common.ReceiveDataConverter;
import com.sensenets.sinopec.kafka.config.KafkaConsumerConfig;
import com.sensenets.sinopec.kafka.config.KafkaReceiveConfig;
import com.sensenets.sinopec.kafka.core.ExchangeMessageHandler;
import com.sensenets.sinopec.kafka.core.KafkaConsumerParam;
import com.sensenets.sinopec.kafka.core.KafkaConsumerService;
import com.sensenets.sinopec.kafka.core.KafkaMessageHandler;

import lombok.extern.slf4j.Slf4j;


/**
  * @ClassName: KafkaConsumerStartup
  * @Description: 消费kafka数据服务启动
  * @author think
  * @date 2018年9月11日 上午11:04:38
  *
  */
@Component
@Slf4j
public class KafkaConsumerStartup implements ApplicationListener<ContextRefreshedEvent> {
    
    @Autowired
    @Qualifier(value = "kafkaReceiveMessageHandler")
    private ExchangeMessageHandler receiveMessageHandler;

    @Autowired
    private KafkaReceiveConfig kafkaReceiveConfig;
    
    @SuppressWarnings("static-access")
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(kafkaReceiveConfig.isEnabled()&&kafkaReceiveConfig.isGasStationEnabled()){
            ReceiveDataConverter transformer = new ReceiveDataConverter();
            KafkaMessageHandler messageHandler = new KafkaReceiveHandler(receiveMessageHandler, transformer);
            KafkaConsumerParam param = new KafkaConsumerParam();
            param.setBootstrapServers(kafkaReceiveConfig.getGasStationBootstrapServers());
            param.setGroupId(kafkaReceiveConfig.getGasStationGroup());
            param.setTopic(kafkaReceiveConfig.getGasStationTopic());
            param.setProperties(KafkaConsumerConfig.getInstance().getKafkaConfigPropertiesFile());
            KafkaConsumerService service = new KafkaConsumerService(param,messageHandler);
            service.startAsync().awaitRunning();
            log.info("---- Start Gas Station Consumer Finish ！----");
        }
    }
}