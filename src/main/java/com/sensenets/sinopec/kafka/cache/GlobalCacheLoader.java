package com.sensenets.sinopec.kafka.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheLoader;
import com.sensenets.sinopec.kafka.exception.CacheLoadException;

public class GlobalCacheLoader extends CacheLoader<Class<? extends SelfLoadCache>, Object> {
    private static final Logger log = LoggerFactory.getLogger(GlobalCacheLoader.class);

    public GlobalCacheLoader() {
    }

    public Object load(Class<? extends SelfLoadCache> clazz) throws Exception {
        Object object = null;
        SelfLoadCache cache = null;

        try {
            object = clazz.newInstance();
        } catch (Exception ex) {
            log.error(String.format("error while create new instance of [%s]", clazz.getName()), ex);
        }

        Preconditions.checkNotNull(object, "instance of [%s] is NULL.", clazz.getName());

        if (SelfLoadCache.class.isInstance(object)) {
            try {
                cache = SelfLoadCache.class.cast(object);
            } catch (ClassCastException ex) {
                log.error(String.format("error while cast instance of [%s] to SelfLoadCache", clazz.getName()), ex);
            }
        }

        Preconditions.checkNotNull(cache, "instance of SelfLoadCache is NULL.");

        try {
            cache.load();
        } catch (CacheLoadException ex) {
            throw ex;
        }

        return cache;
    }
}