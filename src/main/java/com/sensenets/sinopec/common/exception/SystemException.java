package com.sensenets.sinopec.common.exception;
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 8882366904034518521L;

    private Integer code;

    private String message;

    private boolean customMsg = true;

    public SystemException(Integer code) {
        super();
        this.code = code;
    }

    public SystemException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public SystemException(Integer code, String message, boolean customMsg) {
        super();
        this.code = code;
        this.message = message;
        this.customMsg = customMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "code ..." + code;
    }

    public boolean isCustomMsg() {
        return customMsg;
    }
}