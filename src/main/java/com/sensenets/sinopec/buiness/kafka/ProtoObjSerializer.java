package com.sensenets.sinopec.buiness.kafka;

import dg.model.PimpObject;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-20 15:32
 * @desc protobuf序列化
 */
public class ProtoObjSerializer implements Serializer<PimpObject.ObjectPublish> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, PimpObject.ObjectPublish  obj  ) {
        return obj.toByteArray();
    }

    @Override
    public void close() {

    }
}
