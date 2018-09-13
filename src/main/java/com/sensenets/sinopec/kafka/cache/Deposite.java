package com.sensenets.sinopec.kafka.cache;

public interface Deposite<T> {
	boolean update(Object o);
	T get();
	void registerListener(Listener<T> listener);
	void deregisterListener(Listener<T> listener);
	
	public static interface Listener<T> {
		void onChanged(T oldValue, T newValue);
	}
}
