package com.sensenets.sinopec.common.utils;

import java.util.concurrent.*;

/**
 * Created by zhukai on 2017/10/19.
 */
public class ThreadPoolUtils {

    private static ThreadPoolExecutor cachedThreadPool;
    
    private static ThreadPoolExecutor cachedCpatureThreadPool;
    
    private static ThreadPoolExecutor cachedRequestThreadPool;
    
    private static ThreadPoolExecutor cachedCountThreadPool;

    private static ExecutorService fixedThreadPool;

    private static ScheduledExecutorService scheduledExecutorService;

    public static ExecutorService newFixedThreadPool(int nThreads) {
        fixedThreadPool =  new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        return fixedThreadPool;
    }

    public static ThreadPoolExecutor newCachedThreadPool() {
        if (cachedThreadPool == null) {
            cachedThreadPool = new ThreadPoolExecutor(80, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        }
        return cachedThreadPool;
    }
    
    public static ThreadPoolExecutor newCachedCpatureThreadPool() {
        if (cachedCpatureThreadPool == null) {
            cachedCpatureThreadPool = new ThreadPoolExecutor(80, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        }
        return cachedCpatureThreadPool;
    }
    
    public static ThreadPoolExecutor newCachedRequestThreadPool() {
        if (cachedRequestThreadPool == null) {
            cachedRequestThreadPool = new ThreadPoolExecutor(10, 35, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        }
        return cachedRequestThreadPool;
    }
    
    public static ThreadPoolExecutor newCachedCountThreadPool() {
        if (cachedCountThreadPool == null) {
            cachedCountThreadPool = new ThreadPoolExecutor(80, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        }
        return cachedCountThreadPool;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);
        return scheduledExecutorService;
    }
}
