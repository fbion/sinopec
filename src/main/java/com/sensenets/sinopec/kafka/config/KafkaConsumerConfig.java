/**
 * Copyright: Copyright (c) 2018 
 * Company:xuzch
 * 
 * @author xuzch
 * @date 2018年6月27日 上午11:45:00
 * @version V1.0
 */
package com.sensenets.sinopec.kafka.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
  * @ClassName: KafkaConsumerConfig
  * @Description: 深瞳接口用到的kafka相关的配置
  * @author xuzch
  * @date 2018年6月27日 上午11:45:00
  *
  */

public class KafkaConsumerConfig {

    /**
     * 系统配置文件名
     */
    private static final String CONFIG_FILE_NAME = "kafka_consumer.properties";
    
    private static Properties kafkaConfigPropertiesFile;
    
    private KafkaConsumerConfig() {
        InputStream inputStream = null;
        try {
            inputStream = KafkaConsumerConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
            kafkaConfigPropertiesFile = new Properties();
            kafkaConfigPropertiesFile.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputStream = null;
        }
    }

    private static class CloudStorageConfigHolder {
        private static final KafkaConsumerConfig CONFIG = new KafkaConsumerConfig();
    }
    
    /**
     * 获取单例
     * 
     * @return
     */
    public static KafkaConsumerConfig getInstance() {
        return CloudStorageConfigHolder.CONFIG;
    }

    /**
     * getter method
     * @return the kafkaConfigPropertiesFile
     */
    public static Properties getKafkaConfigPropertiesFile() {
        return kafkaConfigPropertiesFile;
    }

    /**
     * setter method
     * @param kafkaConfigPropertiesFile the kafkaConfigPropertiesFile to set
     */
    public static void setKafkaConfigPropertiesFile(Properties kafkaConfigPropertiesFile) {
        KafkaConsumerConfig.kafkaConfigPropertiesFile = kafkaConfigPropertiesFile;
    }
    
}
