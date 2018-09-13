package com.sensenets.sinopec.kafka.cache;

public class DirectDeposite<T> extends AbstractDeposite<T> {

	@SuppressWarnings("unchecked")
	@Override
	protected T parseValue(Object o) {
		T newValue = (T)o;
		return newValue;
	}

}