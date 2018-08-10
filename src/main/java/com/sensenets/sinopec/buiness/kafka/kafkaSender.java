package com.sensenets.sinopec.buiness.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: kafkaProducer
 * @Description: 消息生产者
 * @author think
 * @date 2018年8月10日 下午2:39:00
 *
 */
@Component
public class kafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public  void send(String topic, String content) {
        kafkaTemplate.send(topic, content);
        kafkaTemplate.metrics();
        kafkaTemplate.execute(new KafkaOperations.ProducerCallback<String, String, Object>() {
            @Override
            public Object doInKafka(Producer<String, String> producer) {
                // 这里可以编写kafka原生的api操作
                return null;
            }
        });

        // 消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
            }

            @Override
            public boolean isInterestedInSuccess() {
                return false;
            }
        });
    }
}
