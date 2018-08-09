package com.sensenets.sinopec.common.exception;

import lombok.Data;

/**
 * @ClassName: BussinessException
 * @Description: 业务异常的封装
 * @author think
 * @date 2018年8月9日 上午9:55:05
 *
 */
@Data
public class BusinessException extends RuntimeException {

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 8795813052731529234L;

    /**
     * @Fields errorCode : 错误码
     */
    private Integer errorCode;

    /**
     * @Fields errorMsg : 错误提示信息
     */
    private String errorMsg;
    
    /**
     * @Fields urlPath : 业务异常跳转的页面
     */
    private String urlPath;

    public BusinessException(BizExceptionEnum bizExceptionEnum) {
        super();
        this.errorCode = bizExceptionEnum.getCode();
        this.errorMsg = bizExceptionEnum.getMessage();
        this.urlPath = bizExceptionEnum.getUrlPath();
    }

    public BusinessException(BizExceptionEnum bizExceptionEnum, Throwable cause) {
        super(cause);
        this.errorCode = bizExceptionEnum.getCode();
        this.errorMsg = bizExceptionEnum.getMessage();
        this.urlPath = bizExceptionEnum.getUrlPath();
    }

    public BusinessException(Integer code) {
        super();
        this.errorCode = code;
    }

    public BusinessException(Integer code, String message) {
        super();
        this.errorCode = code;
        this.errorMsg = message;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(cause);
        this.errorCode = code;
        this.errorMsg = message;
    }
}