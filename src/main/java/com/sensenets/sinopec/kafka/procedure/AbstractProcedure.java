package com.sensenets.sinopec.kafka.procedure;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.sensenets.sinopec.kafka.diagnostics.ProcedureDiagnostics;

public abstract class AbstractProcedure<T> implements Procedure<T> {
	private static final Logger log = LoggerFactory.getLogger(AbstractProcedure.class);

	protected ListeningExecutorService executorService;
	protected ProcedureCallback<T> procedureCallback;

	public AbstractProcedure(ListeningExecutorService executorService) {
		this(executorService, null);
	}
	
	public AbstractProcedure(ListeningExecutorService executorService, ProcedureCallback<T> procedureCallback) {
		this.executorService = executorService;
		this.procedureCallback = procedureCallback;
	}

	protected abstract T doProcess(T message) throws Exception;

	public abstract String getName();

	protected T preprocess(T message) {
		T result = message;

		try {
			result = doPreprocess(message);
		} catch (Exception ex) {
			log.error(String.format("[%s] error occurs while pre processing message!", getName()), ex);
		}

		return result;
	}

	protected T doPreprocess(T message) throws Exception {
		return message;
	}

	public T process(T message) throws ProcedureExecutionException, ProcedureFailureException {
		T preprocessed = preprocess(message);
		T result = null;
		long start = System.currentTimeMillis();

		try {
			result = doProcess(preprocessed);
		} catch (ProcedureExecutionException ex) {
			throw ex;
		} catch (ProcedureFailureException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new ProcedureFailureException(getName(), String.format("[%s] procedure unknown error!", getName()),
					ex);
		}

		long end = System.currentTimeMillis();
		ProcedureDiagnostics.getInstance().timeProcess(getName(), end - start);

		return result;
	}

	public ListenableFuture<T> processAsync(T message) throws RejectedExecutionException {
		try {
			return processAsync0(message);
		} catch (RejectedExecutionException e) {
			reportRejected(message, e);
			throw e;
		}
	}

	private ListenableFuture<T> processAsync0(final T message) throws RejectedExecutionException {
		ListenableFuture<T> future;

		if (executorService.isShutdown()) {
			throw new RejectedExecutionException("executor service is already shut down.");
		} else {
			final T preprocessed = preprocess(message);
			future = executorService.submit(new Callable<T>() {
				public T call() throws ProcedureExecutionException, ProcedureFailureException {
					T result = null;
					Stopwatch stopwatch = Stopwatch.createStarted();

					try {
						result = doProcess(preprocessed);
						reportSuccess(message);
					} catch (ProcedureExecutionException ex) {
						if (reportException(message, ex)) {
							throw ex;
						} else {
							throw new ProcedureFailureException(getName(),
									String.format("[%s] unhandled procedure exception!", getName()), ex);
						}
					} catch (ProcedureFailureException ex) {
						reportFailure(message, ex);
						throw ex;
					} catch (Exception ex) {
						reportFailure(message, ex);
						throw new ProcedureFailureException(getName(),
								String.format("[%s] procedure unknown error!", getName()), ex);
					}

					stopwatch.stop();
					ProcedureDiagnostics.getInstance().timeProcess(getName(), stopwatch.elapsed(TimeUnit.MILLISECONDS));

					return result;
				}
			});
		}

		return future;
	}
	
	private void reportSuccess(T message) {
		if (procedureCallback != null) {
			try {
				procedureCallback.onSuccess(message);
			} catch (Exception e) {
				log.error("error while reporting procedure success.", e);
			}
		}
	}

	private boolean reportException(T message, Throwable cause) {
		boolean handled = false;
		if (procedureCallback != null) {
			try {
				handled = procedureCallback.onException(message, cause);
			} catch (Exception e) {
				log.error("error while reporting procedure exception.", e);
			}
		} else {
			handled = true;
		}
		
		return handled;
	}
	
	private void reportFailure(T message, Throwable cause) {
		if (procedureCallback != null) {
			try {
				procedureCallback.onFailure(message, cause);
			} catch (Exception e) {
				log.error("error while reporting procedure failure.", e);
			}
		}
	}

	private void reportRejected(T message, Throwable cause) {
		if (procedureCallback != null) {
			try {
				procedureCallback.onRejected(message, cause);
			} catch (Exception e) {
				log.error("error while reporting procedure rejected.", e);
			}
		}
	}
}