/**
 * Copyright: Copyright (c) 2018 
 * Company:xuzch
 * 
 * @author xuzch
 * @date 2018年6月27日 上午11:45:00
 * @version V1.0
 */
package com.sensenets.sinopec.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


/**
  * @ClassName: KafkaReceiveConfig
  * @Description: kafka接收数据配置
  * @author think
  * @date 2018年9月11日 上午11:06:40
  *
  */
@Configuration
@ConfigurationProperties(prefix = "kafka.receive")
@Data
public class KafkaReceiveConfig {

    private String gasStationBootstrapServers;
    private String gasStationGroup;
    private String gasStationTopic;
    
    private boolean enabled;
    private boolean gasStationEnabled;
    
}
