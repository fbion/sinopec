package com.sensenets.sinopec.kafka.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;


/**
  * @ClassName: kafkaProducerConfig
  * @Description: kafak生产配置
  * @author xuzch
  * @date 2018年7月1日 上午2:58:33
  *
  */
public class KafkaProducerConfig implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	/**
     * 系统配置文件名
     */
    private static final String CONFIG_FILE_NAME = "kafka_producer.properties";
    
	private static Properties kafkaConfigPropertiesFile;
    
	private KafkaProducerConfig() {
        InputStream inputStream = null;
       
        try {
            inputStream = KafkaProducerConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
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
		private static final KafkaProducerConfig CONFIG = new KafkaProducerConfig();
	}
	
	/**
	 * 获取单例
	 * 
	 * @return
	 */
	public static KafkaProducerConfig getInstance() {
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
        KafkaProducerConfig.kafkaConfigPropertiesFile = kafkaConfigPropertiesFile;
    }
	
	
}
