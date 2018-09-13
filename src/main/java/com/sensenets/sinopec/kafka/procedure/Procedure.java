package com.sensenets.sinopec.kafka.procedure;

import java.util.concurrent.RejectedExecutionException;

import com.google.common.util.concurrent.ListenableFuture;

public interface Procedure<T> {
    String getName();
    T process(T message) throws ProcedureExecutionException, ProcedureFailureException;
    ListenableFuture<T> processAsync(T message) throws RejectedExecutionException;
}