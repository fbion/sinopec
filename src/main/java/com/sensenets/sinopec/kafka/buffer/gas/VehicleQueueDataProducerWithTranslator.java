package com.sensenets.sinopec.kafka.buffer.gas;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

/**
  * @ClassName: CommonObjProducerWithTranslator
  * @Description: 业务事件生产并传输（v3.0之后版本支持）
  * @author xzc
 * @param <E>
  * @date 2017年7月19日 下午2:33:24
  *
  */
public class VehicleQueueDataProducerWithTranslator<VehicleQueueDataDto> {
    private final RingBuffer<VehicleQueueDataObj<VehicleQueueDataDto>> ringBuffer;

    public VehicleQueueDataProducerWithTranslator(RingBuffer<VehicleQueueDataObj<VehicleQueueDataDto>> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private  final EventTranslatorOneArg<VehicleQueueDataObj<VehicleQueueDataDto>, VehicleQueueDataDto> TRANSLATOR = new EventTranslatorOneArg<VehicleQueueDataObj<VehicleQueueDataDto>, VehicleQueueDataDto>() {
        public void translateTo(VehicleQueueDataObj<VehicleQueueDataDto> event, long sequence,VehicleQueueDataDto entity) {
            event.setEntity(entity);
        }
    };

    public void onData(VehicleQueueDataDto entity) {
        ringBuffer.publishEvent(TRANSLATOR, entity);
    }
}