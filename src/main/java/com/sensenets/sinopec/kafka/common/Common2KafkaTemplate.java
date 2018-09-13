package com.sensenets.sinopec.kafka.common;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
  * @ClassName: Common2KafkaTemplate
  * @Description: 模板
  * @author think
  * @date 2018年9月10日 下午5:55:22
  *
  */
public abstract class Common2KafkaTemplate {
    
    static final Logger log = LoggerFactory.getLogger(Common2KafkaTemplate.class);
    
    final Charset defaultEncoding = Charset.forName("UTF-8");
    
    static final String defaultEncode = "UTF-8";

    /**
     * 处理数据之前
     */
    public List<byte[]> beforeProcess(final List<ByteBuffer> list) {
        List<byte[]> data = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (ByteBuffer buffer : list) {
                final byte[] infoData = new byte[buffer.remaining()];
                buffer.get(infoData, 0, infoData.length);
                data.add(infoData);
            }
        }
        return data;
    }

}
