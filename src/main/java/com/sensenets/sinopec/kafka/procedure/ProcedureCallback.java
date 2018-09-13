package com.sensenets.sinopec.kafka.procedure;

public interface ProcedureCallback<T> {
	void onSuccess(T message);
	boolean onException(T message, Throwable cause);
	void onFailure(T message, Throwable cause);
	void onRejected(T message, Throwable cause);
}
