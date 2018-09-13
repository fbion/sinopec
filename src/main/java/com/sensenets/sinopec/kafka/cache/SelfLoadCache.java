package com.sensenets.sinopec.kafka.cache;

import com.sensenets.sinopec.kafka.exception.CacheLoadException;

public interface SelfLoadCache {
    void load() throws CacheLoadException;
}