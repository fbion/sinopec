package com.sensenets.sinopec.kafka.common;

import java.io.Serializable;

import lombok.Data;


/**
  * @ClassName: KafkaDataBatch
  * @Description: 批量数据抽象类
  * @author think
  * @date 2018年9月11日 上午11:33:21
  *
  */
@Data
public abstract class KafkaDataBatch<T> implements Serializable{

    private static final long serialVersionUID = -5601947477217914881L;

    String uuid ;
    
    KafkaDataType dataType;
    
    KafkaDataFormatType formatType;
    
    T data;

    
}
