package com.sensenets.sinopec.kafka.cache;

import java.util.Iterator;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensenets.sinopec.kafka.exception.CacheCadidateException;
import com.sensenets.sinopec.kafka.exception.CacheLoadException;

public abstract class AbstractSelfLoadCache implements SelfLoadCache {
	private static final Logger log = LoggerFactory.getLogger(AbstractSelfLoadCache.class);
	
	protected Iterable<CacheCadidate> cadidates;
	
	public AbstractSelfLoadCache() {
		log.debug("AbstractSelfLoadCache() constructor.");
	}

	public AbstractSelfLoadCache(Iterable<CacheCadidate> cadidates) {
		log.debug("AbstractSelfLoadCache(cadidates) constructor.");
		this.cadidates = cadidates;
	}
	
	@Override
	public void load() throws CacheLoadException {
		if (cadidates == null) {
			throw new CacheLoadException(this.getClass(), "no available cache cadidate!");
		}
		
		Properties properties = null;
		
		Iterator<CacheCadidate> iterator = cadidates.iterator();
		
		while (iterator.hasNext()) {
			CacheCadidate cadidate = iterator.next();
			try {
				properties = cadidate.load();
				break;
			} catch (CacheCadidateException e) {
				log.warn(String.format("error loading properties from cadidate: %s", cadidate.getClass().getName()), e);
			}
		}
	
		if (properties == null) {
			throw new CacheLoadException(this.getClass(), "can not load properties from cadidates!");
		}
		
		doLoad(properties);
	}
	
	protected abstract void doLoad(Properties properties) throws CacheLoadException;
}
