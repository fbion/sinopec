package com.sensenets.sinopec.kafka.core;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaRawMessage {
	private String topic;
	private int partition;
	private long offset;
	private long timestamp;
	private byte[] key;
	private byte[] message;
	private long checksum;
	
	@SuppressWarnings("deprecation")
    public static KafkaRawMessage fromRecord(ConsumerRecord<byte[], byte[]> record) {
		KafkaRawMessage message = new KafkaRawMessage();
		message.setTopic(record.topic());
		message.setPartition(record.partition());
		message.setOffset(record.offset());
		message.setTimestamp(record.timestamp());
		message.setKey(record.key());
		message.setMessage(record.value());
		message.setChecksum(record.checksum());
		
		return message;
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getPartition() {
		return partition;
	}
	public void setPartition(int partition) {
		this.partition = partition;
	}
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public byte[] getKey() {
		return key;
	}
	public void setKey(byte[] key) {
		this.key = key;
	}
	public byte[] getMessage() {
		return message;
	}
	public void setMessage(byte[] message) {
		this.message = message;
	}
	public long getChecksum() {
		return checksum;
	}
	public void setChecksum(long checksum) {
		this.checksum = checksum;
	}
}
