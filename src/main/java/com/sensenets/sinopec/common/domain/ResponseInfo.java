package com.sensenets.sinopec.common.domain;

import java.io.Serializable;

public class ResponseInfo implements Serializable{
	
    private static final long serialVersionUID = 377149733311412205L;

    private int code = 200;
	
	private String message = "操作成功";
	
    private String error = "";
	
	private long  timestamp = System.currentTimeMillis();
	
	private Object data;
	
	private Status status = Status.SUCCESS;
	
	public enum Status{
		ERROR,
		SUCCESS,
		WARN
	}

	public ResponseInfo(int code, String message) {
        this.code = code;
        if(code != 200)
            status = Status.ERROR;
        this.message = message;
    }
	
	public ResponseInfo(int code, String message, Object data) {
		this.code = code;
		if(code != 200)
			status = Status.ERROR;
		this.message = message;
		this.data = data;
		
	}
	public ResponseInfo(Status status, String message, Object data) {
		this.message = message;
		this.data = data;
		this.status = status;
		if(status != Status.SUCCESS)
			code = 500;
	}


	public ResponseInfo() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
		if(code != 200)
			status = Status.ERROR;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ResponseInfo addMessage(Status status, String message){
		this.status = status;
		this.message = message;
		return this;
	}
	
	public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ResponseInfo [code=" + code + ", message=" + message + ", error=" + error + ", timestamp=" + timestamp + ", data=" + data + ", status=" + status
                + "]";
    }

    

    
}
