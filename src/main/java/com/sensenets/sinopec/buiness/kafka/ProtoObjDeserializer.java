package com.sensenets.sinopec.buiness.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.protobuf.InvalidProtocolBufferException;

import dg.model.PimpObject;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-20 15:47
 * @desc protobuf反序列化
 */
public class ProtoObjDeserializer implements Deserializer<PimpObject.ObjectPublish> {

    @Override
    public PimpObject.ObjectPublish deserialize(String s, byte[] bytes) {
        try {
            PimpObject.ObjectPublish obj = PimpObject.ObjectPublish.parseFrom(bytes);
            return obj;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {

    }
 

   
    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        
    }
}
