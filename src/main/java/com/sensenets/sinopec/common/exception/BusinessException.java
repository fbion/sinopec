package com.sensenets.sinopec.common.exception;

import com.sensenets.sinopec.common.enums.BizExceptionEnum;

import lombok.Data;

/**
 * @ClassName: BussinessException
 * @Description: 业务异常的封装
 * @author think
 * @date 2018年8月9日 上午9:55:05
 *
 */
@Data
public class BusinessException extends BaseException {


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