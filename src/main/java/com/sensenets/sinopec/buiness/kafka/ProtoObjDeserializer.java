package com.sensenets.sinopec.buiness.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import dg.model.PimpObject;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-20 15:47
 * @desc TODO
 */
public class ProtoObjDeserializer implements Deserializer<PimpObject.ObjectPublish> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

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
}
