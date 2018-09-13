package com.sensenets.sinopec.kafka.common;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensenets.sinopec.common.utils.BeanHelper;
import com.sensenets.sinopec.kafka.cache.SelfLoadCache;
import com.sensenets.sinopec.kafka.config.KafkaProducerConfig;
import com.sensenets.sinopec.kafka.config.KafkaSendConfig;
import com.sensenets.sinopec.kafka.core.KafkaProducerClient;
import com.sensenets.sinopec.kafka.exception.CacheLoadException;


public class KafkaProducerHolder implements SelfLoadCache {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducerHolder.class);
	
	private volatile KafkaProducerClient producer;

	@SuppressWarnings("static-access")
    @Override
	public void load() throws CacheLoadException {
		try {
			Properties properties = KafkaProducerConfig.getInstance().getKafkaConfigPropertiesFile();
			String zookeeperServers = BeanHelper.getBean(KafkaSendConfig.class).getZookeepers();
			if(StringUtils.isNotBlank(zookeeperServers)&&properties!=null){
			    properties.setProperty("zookeeper.connect",zookeeperServers);
			    log.warn("====> using kafka zookeeper servers: {}", zookeeperServers);
			}
			KafkaProducerClient kafkaProducer = new KafkaProducerClient();
			String bootstrapServers = BeanHelper.getBean(KafkaSendConfig.class).getBrokers();
			log.warn("====> using kafka bootstrap servers: {}", bootstrapServers);
			kafkaProducer.open(bootstrapServers, properties);
			
			producer = kafkaProducer;
		} catch (Exception e) {
			log.error("error while creating kafka producer", e);
			throw new CacheLoadException(KafkaProducerHolder.class, "failed to create kafka producer!", e);
		}
	}
	
	public KafkaProducerClient getProducer() {
		return producer;
	}

}
