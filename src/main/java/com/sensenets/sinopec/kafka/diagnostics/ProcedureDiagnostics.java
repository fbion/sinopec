package com.sensenets.sinopec.kafka.diagnostics;

import com.google.common.collect.Lists;

public class ProcedureDiagnostics extends Diagnostics {
    
    private static final String COUNTER_PROCEDURE_START = "PROCEDURE - START";
    private static final String COUNTER_PROCEDURE_COMPLETE = "PROCEDURE - COMPLETE";
    private static final String COUNTER_PROCEDURE_REJECT = "PROCEDURE - REJECT";
    private static final String COUNTER_PROCEDURE_EXCEPTION = "PROCEDURE - EXCEPTION";
    private static final String COUNTER_PROCEDURE_ERROR = "PROCEDURE - ERROR";
    private static final String TIMER_PROCEDURE = "PROCEDURE TIME";
    private static final String TIMER_PROCESS = "PROCESS TIME";

    private static class SingletonHolder {
        private final static ProcedureDiagnostics INSTANCE = new ProcedureDiagnostics();
    }

    public static ProcedureDiagnostics getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ProcedureDiagnostics() {
    	super(
    			"procedures",
    			Lists.newArrayList(
    					COUNTER_PROCEDURE_START,
    					COUNTER_PROCEDURE_COMPLETE,
    					COUNTER_PROCEDURE_REJECT,
                        COUNTER_PROCEDURE_EXCEPTION,
    					COUNTER_PROCEDURE_ERROR),
    			Lists.newArrayList(
    					TIMER_PROCEDURE,
    					TIMER_PROCESS));
    }

    public long countStart(String type) {
        return count(COUNTER_PROCEDURE_START, type);
    }

    public long countComplete(String type) {
        return count(COUNTER_PROCEDURE_COMPLETE, type);
    }

    public long countReject(String type) {
        return count(COUNTER_PROCEDURE_REJECT, type);
    }

    public long countException(String type) {
        return count(COUNTER_PROCEDURE_EXCEPTION, type);
    }

    public long countError(String type) {
        return count(COUNTER_PROCEDURE_ERROR, type);
    }

    public void timeProcedure(String name, long period) {
        time(TIMER_PROCEDURE, name, period);
    }

    public void timeProcess(String name, long period) {
    	time(TIMER_PROCESS, name, period);
    }
}