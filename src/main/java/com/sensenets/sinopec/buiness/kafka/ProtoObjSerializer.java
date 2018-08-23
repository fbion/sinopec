package com.sensenets.sinopec.buiness.kafka;

import org.apache.kafka.common.serialization.Serializer;

import dg.model.PimpObject;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-20 15:32
 * @desc protobuf序列化
 */
public class ProtoObjSerializer  extends PimpObjAdapter implements Serializer<PimpObject.ObjectPublish> {

    @Override
    public byte[] serialize(String s, PimpObject.ObjectPublish  obj  ) {
        return obj.toByteArray();
    }

}
