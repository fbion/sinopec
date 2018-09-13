package com.sensenets.sinopec.kafka.buffer.gas;

import com.lmax.disruptor.EventFactory;

/**
 * @ClassName: CommonObjFactory
 * @Description: 通用业务对象工厂
 * @author xzc
 * @param <E>
 * @date 2017年7月19日 下午4:10:20
 *
 */
public class VehicleQueueDataFactory<VehicleQueueDataDto> implements EventFactory<VehicleQueueDataObj<VehicleQueueDataDto>> {

   
    @Override
    public VehicleQueueDataObj<VehicleQueueDataDto> newInstance() {
        return new VehicleQueueDataObj<VehicleQueueDataDto>();
    }

}
