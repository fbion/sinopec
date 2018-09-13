package com.sensenets.sinopec.kafka.cache;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.ForwardingLoadingCache;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class GlobalCache extends ForwardingLoadingCache<Class<? extends SelfLoadCache>, Object> {
    private static final Logger log = LoggerFactory.getLogger(GlobalCache.class);
    
    private static final long DEFAULT_EXPIRE_DURATION = 60 * 60;
    
    private static class SingletonHolder {
        private final static GlobalCache INSTANCE = new GlobalCache();
    }

    public static GlobalCache getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final LoadingCache<Class<? extends SelfLoadCache>, Object> delegate;

    private GlobalCache() {
    	log.debug("GlobalCache() constructor.");
        delegate = CacheBuilder.newBuilder()
            .initialCapacity(50)
            .maximumSize(1000)
            .concurrencyLevel(4)
            .expireAfterAccess(DEFAULT_EXPIRE_DURATION, TimeUnit.SECONDS)
            .removalListener(new GlobalCacheRemovalListener())
            .build(new GlobalCacheLoader());
    }

    protected final LoadingCache<Class<? extends SelfLoadCache>, Object> delegate() {
        return delegate;
    }

    public static <T extends SelfLoadCache> T getCache(Class<T> clazz) throws Exception {
        GlobalCache instance = getInstance();
        Object object = null;
        object = instance.get(clazz);

        T cache = null;
        if ((object != null) && (clazz.isInstance(object))) {
            cache = clazz.cast(object);
        }

        return cache;
    }

    public static <T extends SelfLoadCache> void invalidateCache(Class<T> clazz) {
        GlobalCache instance = getInstance();
        instance.invalidate(clazz);
    }

    public static <T extends SelfLoadCache> void invalidateAllCache(Class<T> clazz) {
        GlobalCache instance = getInstance();
        instance.invalidateAll();
    }

    static class GlobalCacheRemovalListener implements RemovalListener<Class<? extends SelfLoadCache>, Object> {
        private static final Logger log = LoggerFactory.getLogger(GlobalCacheRemovalListener.class);

        public void onRemoval(RemovalNotification<Class<? extends SelfLoadCache>, Object> notification) {
            log.warn("@@@@@ GLOBAL CACHE @@@@@ [{}] is removed.", notification.getKey().getName());
        }
    }
}