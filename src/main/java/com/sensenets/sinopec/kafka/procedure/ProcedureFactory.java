package com.sensenets.sinopec.kafka.procedure;

import java.util.Collection;

public interface ProcedureFactory<T> {
    Collection<Procedure<T>> createProcedures();
}