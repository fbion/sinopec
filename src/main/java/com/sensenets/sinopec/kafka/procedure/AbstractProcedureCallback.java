package com.sensenets.sinopec.kafka.procedure;

public abstract class AbstractProcedureCallback<T> implements ProcedureCallback<T> {

	@Override
	public void onSuccess(T message) {
	}

	@Override
	public boolean onException(T message, Throwable cause) {
		return true;
	}

	@Override
	public void onFailure(T message, Throwable cause) {
	}

	@Override
	public void onRejected(T message, Throwable cause) {
	}

}
