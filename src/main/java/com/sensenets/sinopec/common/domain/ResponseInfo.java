package com.sensenets.sinopec.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ResponseInfo",description="通用响应对象")
public class ResponseInfo implements Serializable{
	
    private static final long serialVersionUID = 377149733311412205L;

    @ApiModelProperty(value="响应码",name="code",example="如：400,500,12000等")
    private int code = 200;
	
    @ApiModelProperty(value="响应提示",name="message",example="如：操作成功，操作失败，系统异常等")
	private String message = "操作成功";
	
    @ApiModelProperty(value="异常响应提示",name="error",example="如：服务器异常")
    private String error = "";
	
    @ApiModelProperty(value="时间戳",name="timestamp",example="13458638658")
	private long  timestamp = System.currentTimeMillis();
	
    @ApiModelProperty(value="响应数据",name="data")
	private Object data;
	
    @ApiModelProperty(value="响应状态",name="status",example="如：ERROR,SUCCESS,WARN")
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
