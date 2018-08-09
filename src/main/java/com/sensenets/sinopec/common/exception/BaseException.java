package com.sensenets.sinopec.common.exception;

import lombok.Data;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 15:01
 * @desc 公共异常
 */
@Data
public abstract class BaseException extends RuntimeException {
    /**
     * @Fields errorCode : 错误码
     */
    protected Integer errorCode;

    /**
     * @Fields errorMsg : 错误提示信息
     */
    protected String errorMsg;

    /**
     * @Fields urlPath : 业务异常跳转的页面
     */
    protected String urlPath;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message,Throwable cause) {
        super(message,cause);
    }

}
