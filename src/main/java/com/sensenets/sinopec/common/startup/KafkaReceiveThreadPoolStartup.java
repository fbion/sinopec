package com.sensenets.sinopec.common.startup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sensenets.sinopec.config.AppConfig;
import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueDataHandler;
import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueDataHelper;
import com.sensenets.sinopec.kafka.common.KafkaDataType;
import com.sensenets.sinopec.kafka.config.KafkaReceiveConfig;

import lombok.extern.slf4j.Slf4j;

/**
  * @ClassName: KafkaReceiveThreadPoolStartup
  * @Description: 消费kafka数据线程池启动
  * @author think
  * @date 2018年9月11日 上午11:03:30
  *
  */
@Component
@Slf4j
public class KafkaReceiveThreadPoolStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AppConfig config;

    @Autowired
    private KafkaReceiveConfig kafkaReceiveConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (kafkaReceiveConfig.isEnabled()) {
            initPool(config, KafkaDataType.GAS_STATION);
            VehicleQueueDataHelper.getInstance();
            log.info("---- Start Gas Station data receive  thread pool finish ！----");
        }
    }

    private void initPool(AppConfig config, KafkaDataType type) {
        int min = 5;
        int max = 50;
        switch (type) {
        case GAS_STATION:
            min = config.getReceiveGasStationThreadMinNum();
            max = config.getReceiveGasStationThreadMaxNum();
            VehicleQueueDataHandler.setPool(getPool(min, max));
            break;
        }
    }

    private ExecutorService getPool(final int min, final int max) {
        ExecutorService pool = null;
        if (min <= 0 || min > 200 || min > max || max <= 0 || max > 500) {
            pool = new ThreadPoolExecutor(5, 50, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        } else {
            pool = new ThreadPoolExecutor(min, max, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        }
        return pool;
    }
}