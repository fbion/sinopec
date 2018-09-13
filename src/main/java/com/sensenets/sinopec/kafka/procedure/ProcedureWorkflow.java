package com.sensenets.sinopec.kafka.procedure;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.sensenets.sinopec.kafka.diagnostics.ProcedureDiagnostics;

public class ProcedureWorkflow<T> {
    private static final Logger log = LoggerFactory.getLogger(ProcedureWorkflow.class);

    public static <E> ProcedureWorkflow<E> createNew(Collection<Procedure<E>> procedures) {
        ProcedureWorkflow<E> workflow = new ProcedureWorkflow<E>();
        workflow.setProcedures(procedures);

        return workflow;
    }

    private Queue<Procedure<T>> procedureQueue;

    private ProcedureWorkflow() {
    }

    private void setProcedures(Collection<Procedure<T>> procedures) {
        Preconditions.checkNotNull(procedures, "procedure collection is NULL!");
        Preconditions.checkState(procedures.size() > 0, "procedure collection is EMPTY!");

        procedureQueue = new ArrayBlockingQueue<>(procedures.size(), true, procedures);
    }

    public T start(T message) throws ProcedureFailureException {
    	if (null == procedureQueue) {
    		throw new ProcedureFailureException("", "procedure queue is NULL!");
    	}
    	
    	if (procedureQueue.size() == 0) {
    		throw new ProcedureFailureException("", "procedure queue is EMPTY!");
    	}

        return process(message);
    }

    private T process(T message) throws ProcedureFailureException {
    	T result;
    	Procedure<T> procedure = procedureQueue.poll();
    	if (procedure != null) {
    		ProcedureDiagnostics.getInstance().countStart(procedure.getName());
    		try {
    			result = procedure.process(message);
    		} catch (ProcedureExecutionException ex) {
    			result = message;
    			ProcedureDiagnostics.getInstance().countException(procedure.getName());
    			log.warn(String.format("[%s] procedure exception occurs!", procedure.getName()), ex);
    		} catch (ProcedureFailureException ex) {
    			ProcedureDiagnostics.getInstance().countError(procedure.getName());
    			throw ex;
    		} finally {
    			ProcedureDiagnostics.getInstance().countComplete(procedure.getName());
    		}
    		
    		return process(result);
    	} else {
    		return message;
    	}
    }
    
    public void startAsync(T message) throws ProcedureFailureException {
    	if (null == procedureQueue) {
    		throw new ProcedureFailureException("", "procedure queue is NULL!");
    	}
    	
    	if (procedureQueue.size() == 0) {
    		throw new ProcedureFailureException("", "procedure queue is EMPTY!");
    	}

    	final FutureCallback<T> callback = new FutureCallback<T>() {
            public void onFailure(Throwable t) {

            }

            public void onSuccess(T result) {

            }
        };
        
        processAsync(message, callback);
    }

    public void startAsync(T message, final FutureCallback<T> callback) throws ProcedureFailureException {
    	if (null == procedureQueue) {
    		throw new ProcedureFailureException("", "procedure queue is NULL!");
    	}
    	
    	if (procedureQueue.size() == 0) {
    		throw new ProcedureFailureException("", "procedure queue is EMPTY!");
    	}

    	processAsync(message, callback);
    }

    private void processAsync(final T message, final FutureCallback<T> callback) {
        ListenableFuture<T> future = null;

        Procedure<T> procedure = procedureQueue.poll();

        if (procedure != null) {
            final String name = procedure.getName();

            try {
            	ProcedureDiagnostics.getInstance().countStart(name);
            	final long begin = System.currentTimeMillis();
            	
                future = procedure.processAsync(message);
                
                Futures.addCallback(future, new FutureCallback<T>() {
                    public void onSuccess(T result) {
                        long end = System.currentTimeMillis();
                        ProcedureDiagnostics.getInstance().timeProcedure(name, end - begin);
                        ProcedureDiagnostics.getInstance().countComplete(name);
                        processAsync(result, callback);
                    }
                    public void onFailure(Throwable cause) {
                    	if (cause instanceof ProcedureExecutionException) {
                    		ProcedureDiagnostics.getInstance().countException(name);
                    		ProcedureDiagnostics.getInstance().countComplete(name);
                    		log.warn(String.format("[%s] procedure exception occurs!", name), cause);
                    		processAsync(message, callback);
                    	} else if (cause instanceof ProcedureFailureException) {
                    		ProcedureDiagnostics.getInstance().countError(name);
                    		log.warn(String.format("[%s] procedure error occurs!", name), cause);
                    		callback.onFailure(cause);
                    	} else {
                    		ProcedureDiagnostics.getInstance().countError(name);
                    		log.warn(String.format("[%s] procedure unknown error occurs!", name), cause);
                    		callback.onFailure(cause);
                    	}
                    }
                });
            } catch (RejectedExecutionException ex) {
                ProcedureDiagnostics.getInstance().countReject(name);
                log.error(String.format("[%s] procedure rejected!", procedure.getName()));
                processAsync(message, callback);
            }
        } else {
            future = Futures.immediateFuture(message);
            Futures.addCallback(future, callback);
        }

    }
}