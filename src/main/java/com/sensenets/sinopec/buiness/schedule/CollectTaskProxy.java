/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月29日 下午5:00:44
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.schedule;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.collections.MapUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.sensenets.sinopec.buiness.dto.CollectTaskDto;
import com.sensenets.sinopec.common.enums.CollectTaskStatusEnum;
import com.sensenets.sinopec.common.utils.ThreadHelper;

import lombok.extern.slf4j.Slf4j;

/**
  * @ClassName: MobCollectTaskPool
  * @Description: 移动数据采集代理-创建任务后 
  * 就每一类数据分配一个线程去处理所有类型任务处理完成返回结果，更新任务状态
  * @author think
  * @date 2018年8月29日 下午5:00:44
  *
  */
@Slf4j
public class CollectTaskProxy extends Thread {
    
    /**
     * @Fields TASKEXECUTOR : 线程池
     */
    private static ThreadPoolTaskExecutor TASKEXECUTOR;

    private static ReentrantReadWriteLock readWritLock = new ReentrantReadWriteLock();

    /**
     * @Fields taskIdMap : 存放正在采集的数据的id
     */
    private static volatile ConcurrentMap<Long, Long> taskIdMap = new ConcurrentHashMap<Long, Long>();
    
    private static boolean running = false;
 
    /**
     * @Fields INSTANCE
     */
    private static volatile CollectTaskProxy INSTANCE;

    /**
     * @Title: getInstance
     * @Description: 获取实例
     * @return ExportImgHelper
     */
    public static CollectTaskProxy init() {
        if (INSTANCE == null) {
            synchronized (CollectTaskProxy.class) {
                if (INSTANCE == null) {
                    TASKEXECUTOR = new ThreadPoolTaskExecutor();
                    TASKEXECUTOR.setCorePoolSize(0);
                    TASKEXECUTOR.setMaxPoolSize(2);
                    TASKEXECUTOR.setKeepAliveSeconds(20);
                    TASKEXECUTOR.setQueueCapacity(5);
                    TASKEXECUTOR.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
                    TASKEXECUTOR.initialize();
                    INSTANCE = new CollectTaskProxy();
                    log.info("------MobCollectTaskProxy init ------");
                }
            }
        }
        return INSTANCE;
    }

    private CollectTaskProxy() {
        
    }

    @Override
    public void run() {
        while (true) {
            if (checkRunning()) {
                try {
                    CollectTaskDto task = CollectTaskQueue.take();
                    if (!isExist(task.getId())) {
                        if (task.getTaskStatus() == CollectTaskStatusEnum.RUNNING.getCode()) {
                            log.debug(String.format("***************存在采集任务，开始采集数据*********"));
                            executeCollect(task);
                        }
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
            ThreadHelper.sleepThread(3000);
        }
    }

    private void executeCollect(CollectTaskDto task) {
        TASKEXECUTOR.submit(new CollectSubTask(task));
    }

    private boolean checkRunning() {
        if (running) {
            log.debug("采集线程正在运行");
        } else {
            log.debug("采集线程已停止运行");
        }
        return running;
    }

    /**
     * @Title: stopTask
     * @Description:停止采集
     */
    public static void stopTask() {
        running = false;
    }

    /**
     * @Title: startTask
     * @Description: 开启采集
     */
    public static void startTask() {
        init();
        INSTANCE.start();
        running = true;
    }

    /**
     * @Title: isExist
     * @Description: 判断该条记录是否 正在采集
     * @param taskId
     * @return
     */
    public static boolean isExist(Long taskId) {
        readWritLock.readLock().lock();
        boolean isExist = false;
        if (taskIdMap != null) {
            isExist = taskIdMap.containsKey(taskId);
        }
        readWritLock.readLock().unlock();
        return isExist;
    }

    /**
     * @Title: removeKey
     * @Description: 采集完成移除指定的记录
     * @param taskId
     *            记录id
     * @param isOk
     *            是否成功状态下删除
     */
    public static void removeKey(Long taskId, boolean isOk) {
        readWritLock.writeLock().lock();
        if (MapUtils.isNotEmpty(taskIdMap) && taskIdMap.containsKey(taskId)) {
            taskIdMap.remove(taskId);
            log.debug("移除正在采集的id，采集状态:" + isOk);
        }
        readWritLock.writeLock().unlock();
    }

    /**
     * @Title: putKey
     * @Description: 存放指定的记录
     * @param taskId
     *            检索记录id
     */
    public static void putKey(Long taskId) {
        readWritLock.writeLock().lock();
        if (taskIdMap != null && !taskIdMap.containsKey(taskId)) {
            taskIdMap.put(taskId, taskId);
        }
        readWritLock.writeLock().unlock();
    }

    
}
