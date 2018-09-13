package com.sensenets.sinopec.kafka.cache;

import java.util.Properties;

import com.sensenets.sinopec.kafka.exception.CacheCadidateException;

public class RemoteCacheCadidate implements CacheCadidate {
	
	private final String url;
	private final String namespace;
	
	public RemoteCacheCadidate(String url, String namespace) {
		this.url = url;
		this.namespace = namespace;
	}

	@Override
	public Properties load() throws CacheCadidateException {
		throw new CacheCadidateException("remote cache not provided!");
	}

}
