package com.sensenets.sinopec.kafka.procedure;

public class ProcedureFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6976664326116716124L;


	public ProcedureFailureException(String name, String message) {
        super(message);
        procedureName = name;
    }

    public ProcedureFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcedureFailureException(String name, String message, Throwable cause) {
        super(message, cause);
        procedureName = name;
    }

    public ProcedureFailureException(String name, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        procedureName = name;
    }

    private String procedureName;

    public String getProcedureName() {
        return procedureName;
    }
}
