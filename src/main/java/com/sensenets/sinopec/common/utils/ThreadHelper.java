package com.sensenets.sinopec.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author summer
 *
 */
public class ThreadHelper {

    /**
     * ThreadFactory
     */
    private static ThreadFactory THREAD_FACTORY;

    /**
     * ExecutorService
     */
    private static ExecutorService EXECUTOR_SERVICE;

    /**
     * IS_INITED
     */
    private static boolean IS_INITED = false;

    /**
     * 初始化
     */
    public static void init() {
        if (THREAD_FACTORY == null) {
            THREAD_FACTORY = Executors.defaultThreadFactory();
        }
        if (EXECUTOR_SERVICE == null) {
            EXECUTOR_SERVICE = Executors.newCachedThreadPool(THREAD_FACTORY);
        }
    }

    /**
     * 设置超时时长
     * 
     * @param second
     *            超时时间
     */
    public static void setTimeout(int second) {
        try {
            if (IS_INITED) {
                return;
            }
            // 设置超时时长
            if (EXECUTOR_SERVICE != null) {
                EXECUTOR_SERVICE.awaitTermination(60, TimeUnit.SECONDS);
            }
            IS_INITED = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title: CreateThread
     * @Description: 创建线程
     * @param r
     *            Runnable
     * @return Thread
     */
    public static Thread createThread(Runnable r) {
        return THREAD_FACTORY.newThread(r);
    }

    /**
     * @Title: ThreadStart
     * @Description: 启动线程
     * @param r
     *            Runnable
     */
    public static void startThread(Runnable r) {
        EXECUTOR_SERVICE.execute(r);
    }

    /**
     * @Title: ThreadSleep
     * @Description: 线程休眠
     * @param milSec
     *            休眠时间
     */
    public static void sleepThread(long milSec) {
        try {
            Thread.sleep(milSec);
        } catch (Exception e) {
        }
    }

    /**
     * @Title: ThreadInterrupt
     * @Description: 中断线程
     * @param thread
     *            Thread
     */
    public static void interruptThread(Thread thread) {
        if (thread != null) {
            if (thread.isAlive()) {
                thread.interrupt();
            }
            thread = null;
        }
    }

    /**
     * @Title: ThreadStopAll
     * @Description: 停止所有线程
     */
    public static void stopAllThread() {
        if (EXECUTOR_SERVICE != null && !EXECUTOR_SERVICE.isShutdown()) {
            EXECUTOR_SERVICE.shutdown();
        }
    }
}
