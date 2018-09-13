package com.sensenets.sinopec.kafka.core;

import java.util.Properties;

public class KafkaConsumerParam {
	private String zookeeper;
	private String bootstrapServers;
	private String topic;
	private String groupId;
	private Properties properties;
	
	public String getZookeeper() {
		return zookeeper;
	}
	public void setZookeeper(String zookeeper) {
		this.zookeeper = zookeeper;
	}
	public String getBootstrapServers() {
		return bootstrapServers;
	}
	public void setBootstrapServers(String bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
}
