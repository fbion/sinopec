package com.sensenets.sinopec.kafka.core;

import java.io.Closeable;
import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class KafkaProducerClient implements Closeable {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducerClient.class);

	private Producer<byte[], byte[]> producer;

	public KafkaProducerClient() {
	}

	//huawei security logon on 
	public void open(String bootstrapServers, Properties properties, Properties securityProp,String securityPath)
			throws KafkaClientException {
		
		if (Boolean.parseBoolean(String.valueOf(securityProp.getProperty(KafkaLoginUtil.KAFKA_KBS_ENABLED)))) {
			log.debug("bootstrapServers={}.",bootstrapServers);
			properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
			properties.put(KafkaLoginUtil.KAFKA_KERBEROS_SERVICE_NAME,
					securityProp.getProperty(KafkaLoginUtil.KAFKA_KERBEROS_SERVICE_NAME, "kafka"));
			
			String jassFile = securityProp.getProperty(KafkaLoginUtil.KAFKA_JASS_CONF_PATH);
			securityProp.put(KafkaLoginUtil.KAFKA_JASS_CONF_PATH, securityPath + "/" + jassFile);
			
			String krb5File = securityProp.getProperty(KafkaLoginUtil.KAFKA_KRB5_CONF_PATH);
			securityProp.put(KafkaLoginUtil.KAFKA_KRB5_CONF_PATH, securityPath + "/" + krb5File);
			try {
//				log.debug("kafka_jass_conf_path={}",securityProp.getProperty(KafkaLoginUtil.KAFKA_JASS_CONF_PATH));
//				log.debug("kafka_krb5_conf_path={}",securityProp.getProperty(KafkaLoginUtil.KAFKA_KRB5_CONF_PATH));
				KafkaLoginUtil.check(securityProp);
				log.debug("pass huawei security check.");
			} catch (Exception e) {
				log.debug("!!! HUAWEI FusionInsight HD Kafka security mode exception." + e);
				throw new KafkaClientException(" HUAWEI FusionInsight HD Kafka security mode failed.",e);
			}
		}	
		open(bootstrapServers,properties);
	}

	public void open(String bootstrapServers, Properties properties) throws KafkaClientException {
		try {
			if (!Strings.isNullOrEmpty(bootstrapServers)) {
				properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
			}
			producer = new KafkaProducer<byte[], byte[]>(properties);
		} catch (KafkaException ex) {
			log.debug("kafka error while opening kafka producer!", ex);
			throw new KafkaClientException("kafka error while opening kafka producer!", ex);
		} catch (Exception ex) {
			log.debug("unknown error while opening kafka producer!", ex);
			throw new KafkaClientException("unknown error while opening kafka producer!", ex);
		}
	}

	public void send(String topic, byte[] key, byte[] message) throws KafkaClientException {
		try {
			ProducerRecord<byte[], byte[]> record = new ProducerRecord<byte[], byte[]>(topic, key, message);
			log.debug("START sending kafka message. topic: [{}]", topic);
			RecordMetadata metadata = producer.send(record).get();
			log.debug("kafka send successfully!. topic: [{}], metadata: [{}]", topic, metadata.toString());
		} catch (KafkaException ex) {
			throw new KafkaClientException(String.format("kafka error: kafka send failed!. topic: [%s]", topic), ex);
		} catch (Exception ex) {
			throw new KafkaClientException(String.format("unknown error: kafka send failed!. topic: [%s]", topic), ex);
		}
	}

	public void send(String topic,  byte[] message) throws KafkaClientException {
		try {
			ProducerRecord<byte[], byte[]> record = new ProducerRecord<byte[], byte[]>(topic, message);
			log.debug("START sending list kafka message. topic: [{}]", topic);
			RecordMetadata metadata = producer.send(record).get();
			log.debug("kafka send list successfully!. topic: [{}], metadata: [{}]", topic, metadata.toString());
		} catch (KafkaException ex) {
			throw new KafkaClientException(String.format("kafka error: kafka send list failed!. topic: [%s]", topic), ex);
		} catch (Exception ex) {
			throw new KafkaClientException(String.format("unknown error: kafka send list failed!. topic: [%s]", topic), ex);
		}
	}

	public void close() {
		try {
			producer.close();
		} catch (KafkaException ex) {
			log.error("error while closing kafka producer!", ex);
		}
	}
}
