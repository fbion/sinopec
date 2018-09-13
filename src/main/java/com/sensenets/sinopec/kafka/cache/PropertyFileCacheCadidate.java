package com.sensenets.sinopec.kafka.cache;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.sensenets.sinopec.kafka.exception.CacheCadidateException;

public class PropertyFileCacheCadidate extends PropertyCacheCadidate {

	private final String propertyFilepath;

	public PropertyFileCacheCadidate(String propertyFilepath) {
		this.propertyFilepath = propertyFilepath;
	}

	@Override
	public Properties load() throws CacheCadidateException {
		File propsFile = null;
		Properties properties = new Properties();

		try {
			propsFile = new File(propertyFilepath);
			Preconditions.checkNotNull(propsFile, "property file object is NULL!");
			Preconditions.checkState(propsFile.exists(), "property file is NOT exists!");
		} catch (Exception e) {
			throw new CacheCadidateException("can not open property file.", e);
		}

		try (InputStream inputStream = new BufferedInputStream(new FileInputStream(propsFile))) {
			properties.load(new InputStreamReader(inputStream, Charsets.UTF_8));
		} catch (Exception e) {
			throw new CacheCadidateException("can not load property file.", e);
		}

		return properties;
	}
}
