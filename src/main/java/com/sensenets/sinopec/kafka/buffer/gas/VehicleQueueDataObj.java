package com.sensenets.sinopec.kafka.buffer.gas;

import java.io.Serializable;

/**
 * @ClassName: CommonObj
 * @Description: 通用业务对象
 * @author xzc
 * @param <E>
 * @param <T>
 * @date 2017年7月19日 下午3:59:36
 *
 */
public class VehicleQueueDataObj<VehicleQueueDataDto> implements Serializable{

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 8332549404099884754L;

    private VehicleQueueDataDto entity;

    /**
     * getter method
     * @return  entity
     */
    public VehicleQueueDataDto getEntity() {
        return entity;
    }

    /**
     * setter method
     * @param entity the entity 
     */
    public void setEntity(VehicleQueueDataDto entity) {
        this.entity = entity;
    }

    

}
