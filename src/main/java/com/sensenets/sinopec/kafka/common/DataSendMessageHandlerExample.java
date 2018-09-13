package com.sensenets.sinopec.kafka.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.sensenets.sinopec.common.utils.BeanHelper;
import com.sensenets.sinopec.common.utils.JsonHelper;
import com.sensenets.sinopec.kafka.cache.GlobalCache;
import com.sensenets.sinopec.kafka.config.KafkaSendConfig;
import com.sensenets.sinopec.kafka.core.KafkaClientException;
import com.sensenets.sinopec.kafka.core.KafkaProducerClient;
import com.sensenets.sinopec.kafka.retry.RetryException;
import com.sensenets.sinopec.kafka.retry.Retryer;
import com.sensenets.sinopec.kafka.retry.RetryerBuilder;
import com.sensenets.sinopec.kafka.retry.StopStrategies;
import com.sensenets.sinopec.kafka.retry.WaitStrategies;

import dg.model.PimpRecObj.PetrolStationObj;

/**
 * @ClassName: DataSendMessageHandlerExample
 * @Description: 数据解析后发送到kafka提供给其他服务
 * @author think
 * @date 2018年9月10日 下午5:30:31
 *
 */
public class DataSendMessageHandlerExample {
    private static final Logger log = LoggerFactory.getLogger(DataSendMessageHandlerExample.class);

    public void sendMessage(final KafkaDataBatch<PetrolStationObj> data) {
        try {
            String topic = getTopic(data);
            byte[] key = getKey(data);
            switch(data.getFormatType()){
            case JSON:
                byte[] jsonMessage = getMessageJsonByteArray(data);
                trySend(topic, key, jsonMessage);
                break;
            case PROTOBUF:
                byte[] protoMessage = getMessageProtobufByteArray(data);
                trySend(topic, key, protoMessage);
                break;
            case OBJECT:
                byte[] objectMessage = getMessageObjByteArray(data);
                trySend(topic, key, objectMessage);
                break;
            }
           
        } catch (Exception e) {
            log.error("error while handling leaky face message.", e);
        }
    }

    private void trySend(final String topic, final byte[] key, final byte[] message) throws ExecutionException, RetryException {
        Callable<Void> callable = new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                doSend(topic, key, message);
                return null;
            }
        };

        Retryer<Void> retryer = RetryerBuilder.<Void> newBuilder().retryIfExceptionOfType(KafkaClientException.class)
                .withWaitStrategy(WaitStrategies.<Void> noWait()).withStopStrategy(StopStrategies.<Void> stopAfterAttempt(10)).build();
        retryer.call(callable);
    }

    private void doSend(String topic, byte[] key, byte[] message) throws Exception {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(topic));
        Preconditions.checkNotNull(message, "message data is NULL!");
        Preconditions.checkArgument(message.length > 0, "message data is EMPTY!");

        KafkaProducerHolder producerHolder = GlobalCache.getCache(KafkaProducerHolder.class);
        KafkaProducerClient producer = producerHolder.getProducer();
        Preconditions.checkNotNull(producer, "kafka producer is NULL!");
        producer.send(topic, key, message);
    }

    private byte[] getMessageObjByteArray(KafkaDataBatch<PetrolStationObj> batch) throws Exception {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(batch.getData());
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }
    
    private byte[] getMessageProtobufByteArray(KafkaDataBatch<PetrolStationObj> batch) throws Exception {
        byte[] bytes = null;
        try {
            bytes = batch.getData().toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    private byte[] getMessageJsonByteArray(KafkaDataBatch<PetrolStationObj> batch) throws Exception {
        byte[] bytes = null;
        try {
            bytes = JsonHelper.toJsonByteArray(batch.getData());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    private byte[] getKey(final KafkaDataBatch<PetrolStationObj> data) throws Exception {
        return data.getUuid().getBytes(Charsets.UTF_8);
    }

    private String getTopic(final KafkaDataBatch<PetrolStationObj> data) throws Exception {
        String topic = "";
        switch (data.getDataType()) {
        case GAS_STATION:
            topic = BeanHelper.getBean(KafkaSendConfig.class).getTopicVehicle();
            break;
        }
        Preconditions.checkArgument(!Strings.isNullOrEmpty(topic), "kafka topic for vehicle is NULL!");
        return topic;
    }

}
