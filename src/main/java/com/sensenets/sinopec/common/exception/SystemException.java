package com.sensenets.sinopec.common.exception;

import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.core.support.StrKit;

import lombok.Data;

/**
 * @author think
 * @ClassName: SystemException
 * @Description: 系统异常
 * @date 2018年8月9日 上午10:08:14
 */
@Data
public class SystemException extends BaseException {

    private static final long serialVersionUID = 8882366904034518521L;

    public SystemException(BizExceptionEnum bizExceptionEnum) {
        super();
        this.errorCode = bizExceptionEnum.getCode();
        this.errorMsg = bizExceptionEnum.getMessage();
        this.urlPath = bizExceptionEnum.getUrlPath();
    }

    public SystemException(BizExceptionEnum bizExceptionEnum, Throwable e) {
        super(e);
        this.errorCode = bizExceptionEnum.getCode();
        this.errorMsg = bizExceptionEnum.getMessage();
        this.urlPath = bizExceptionEnum.getUrlPath();
    }

}