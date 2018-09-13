package com.sensenets.sinopec.kafka.cache;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

public abstract class AbstractDeposite<T> implements Deposite<T> {
	protected static final Logger log = LoggerFactory.getLogger(AbstractDeposite.class);
	
	protected Optional<T> valuePossible = Optional.absent();
	private Lock lock = new ReentrantLock();
	private List<WeakReference<Deposite.Listener<T>>> listeners = new ArrayList<>();

	@Override
	public boolean update(Object o) {
		boolean updated = false;
		
		T oldValue = valuePossible.orNull();
		T newValue = null;
		try {
			lock.lock();
			
			if (needUpdate(o)) {
				newValue = parseValue(o);
				valuePossible = Optional.of(newValue);
				updated = true;
			}
		} catch (Exception e) {
			log.error("error while updating value.", e);
		} finally {
			lock.unlock();
		}
		
		if (updated) {
			notifyChange(oldValue, newValue);
		}

		return updated;
	}
	
	protected boolean needUpdate(Object o) {
		return true;
	}
	
	protected abstract T parseValue(Object o);

	@Override
	public T get() {
		try {
			lock.lock();
			return valuePossible.orNull();
		} finally {
			lock.unlock();
		}
	}
	
	private synchronized void notifyChange(T oldValue, T newValue) {
		Iterator<WeakReference<Listener<T>>> iterator = listeners.iterator();
		while(iterator.hasNext()) {
			WeakReference<Listener<T>> reference = iterator.next();
			Listener<T> listener = reference.get();
			if (listener != null) {
				try {
					listener.onChanged(oldValue, newValue);
				} catch (Exception e) {
					log.error("error while notify value changed.", e);
				}
			} else {
				listeners.remove(reference);
			}
		}
	}

	@Override
	public synchronized void registerListener(Deposite.Listener<T> listener) {
		listeners.add(new WeakReference<Listener<T>>(listener));
	}

	@Override
	public synchronized void deregisterListener(Deposite.Listener<T> listener) {
		Iterator<WeakReference<Listener<T>>> iterator = listeners.iterator();
		while(iterator.hasNext()) {
			WeakReference<Listener<T>> reference = iterator.next();
			if (Objects.equals(listener, reference.get())) {
				listeners.remove(reference);
			}
		}
	}

}
