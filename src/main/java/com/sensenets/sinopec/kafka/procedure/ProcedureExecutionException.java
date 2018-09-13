package com.sensenets.sinopec.kafka.procedure;

public class ProcedureExecutionException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8908329748711491472L;

	public ProcedureExecutionException(String name, String message) {
        super(message);
        procedureName = name;
    }

    public ProcedureExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcedureExecutionException(String name, String message, Throwable cause) {
        super(message, cause);
        procedureName = name;
    }

    public ProcedureExecutionException(String name, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        procedureName = name;
    }

    private String procedureName;

    public String getProcedureName() {
        return procedureName;
    }
}