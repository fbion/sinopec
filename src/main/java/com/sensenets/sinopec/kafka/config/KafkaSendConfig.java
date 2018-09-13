package com.sensenets.sinopec.kafka.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
  * @ClassName: kafkaConfig
  * @Description:kafka配置
  * @author xuzch
  * @date 2018年7月1日 上午3:06:50
  *
  */
@Configuration
@ConfigurationProperties(prefix = "kafka.send")
@Data
public class KafkaSendConfig {

    private String zookeepers;
    
    private String brokers;
    
    private String topicVehicle;
    
}
