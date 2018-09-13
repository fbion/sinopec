package com.sensenets.sinopec.kafka.buffer.gas;

import java.util.concurrent.ExecutorService;

import com.lmax.disruptor.EventHandler;

/**
 * @ClassName: CommonObjHandler
 * @Description: 业务事件消费者
 * @author xzc
 * @date 2017年7月19日 下午2:16:46
 *
 */
public class VehicleQueueDataHandler implements EventHandler<VehicleQueueDataObj<VehicleQueueDataDto>> {

    private static ExecutorService pool =  null;
    
   
    public void onEvent(VehicleQueueDataObj<VehicleQueueDataDto> event, long sequence, boolean endOfBatch) {
        if (null != event.getEntity()) {
            try {
                pool.execute(new VehicleQueue2Db(event.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }


    /**
     * getter method
     * @return the pool
     */
    public static ExecutorService getPool() {
        return pool;
    }


    /**
     * setter method
     * @param pool the pool to set
     */
    public static void setPool(ExecutorService pool) {
        VehicleQueueDataHandler.pool = pool;
    }
    
    
   
}