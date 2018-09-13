package com.sensenets.sinopec.kafka.cache;

import java.util.Properties;

import com.google.common.base.Optional;
import com.sensenets.sinopec.kafka.exception.CacheCadidateException;

public class PropertyCacheCadidate implements CacheCadidate {

	protected Optional<Properties> propertiesPossible;
	
	public PropertyCacheCadidate() {
		propertiesPossible = Optional.absent();
	}

	public PropertyCacheCadidate(Properties properties) {
		setProperties(properties);
	}
	
	public synchronized void setProperties(Properties properties) {
		this.propertiesPossible = Optional.fromNullable(properties);
	}
	
	public synchronized Properties getProperties() {
		return propertiesPossible.orNull();
	}
	
	public synchronized void invalidate() {
		propertiesPossible = Optional.absent();
	}

	@Override
	public synchronized Properties load() throws CacheCadidateException {
		if (!propertiesPossible.isPresent()) {
			throw new CacheCadidateException("direct properties is not set yet.");
		}
		
		return propertiesPossible.get();
	}
}
