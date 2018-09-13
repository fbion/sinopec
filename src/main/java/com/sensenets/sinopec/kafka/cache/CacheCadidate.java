package com.sensenets.sinopec.kafka.cache;

import java.util.Properties;

import com.sensenets.sinopec.kafka.exception.CacheCadidateException;

public interface CacheCadidate {
	Properties load() throws CacheCadidateException;;
}
