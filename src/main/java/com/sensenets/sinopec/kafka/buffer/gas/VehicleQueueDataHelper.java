package com.sensenets.sinopec.kafka.buffer.gas;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * @ClassName: DisrupterHelper
 * @Description: disrupter工具
 * @author xzc
 * @date 2017年7月19日 下午4:27:06
 *
 */
public class VehicleQueueDataHelper<E> {

    /**
     * @Fields INSTANCE
     */
    private static volatile VehicleQueueDataHelper<?> INSTANCE;

    /**
     * @Fields BUFFER_SIZE : 指定RingBuffer大小 ，必须为2的倍数
     */
    private static final int BUFFER_SIZE = 2^18;

    private static Disruptor<VehicleQueueDataObj<VehicleQueueDataDto>> disruptor;

    /**
     * @Title: getInstance
     * @Description: 获取实例
     * @return ClearDataImageTaskPool
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static VehicleQueueDataHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (VehicleQueueDataHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VehicleQueueDataHelper();
                    ThreadFactory threadFactory = Executors.defaultThreadFactory();
                    VehicleQueueDataFactory factory = new VehicleQueueDataFactory();
                    // 业务工厂，RingBuffer大小 ，消费者线程池
                    /*
                    //BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
                    WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
                    //SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
                    WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
                    //YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
                    WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
                    */
                    disruptor = new Disruptor(factory, BUFFER_SIZE, threadFactory, ProducerType.SINGLE, new BlockingWaitStrategy());
                    // 连接 业务消费者
                    disruptor.handleEventsWith(new VehicleQueueDataHandler());
                    // 启动
                    disruptor.start();
                }
            }
        }
        return INSTANCE;
    }
    
    public static void producerData(VehicleQueueDataDto entity) {
        getInstance();
        // 获取环形缓冲区准备发布
        RingBuffer<VehicleQueueDataObj<VehicleQueueDataDto>> ringBuffer = disruptor.getRingBuffer();
        producerWithTranslator(ringBuffer,entity);
    }
    
    public static void producerData(VehicleQueueDataDto[] entitys) {
        getInstance();
        // 获取环形缓冲区准备发布
        RingBuffer<VehicleQueueDataObj<VehicleQueueDataDto>> ringBuffer = disruptor.getRingBuffer();
        if(null!=entitys&&entitys.length>0){
            for(VehicleQueueDataDto entity:entitys){
                producerWithTranslator(ringBuffer,entity);
            }
        }
    }


    /**
     * @Title: producerWithTranslator
     * @Description: 第二种发布数据方式（v3.0之后的版本业务生成者对缓冲区的处理方式）
     * @param ringBuffer
     * @param entity 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void producerWithTranslator(RingBuffer<VehicleQueueDataObj<VehicleQueueDataDto>> ringBuffer, VehicleQueueDataDto entity) {
        VehicleQueueDataProducerWithTranslator producer = new VehicleQueueDataProducerWithTranslator(ringBuffer);
        // 生成业务事件并发布
        producer.onData(entity);
    }
  
}
