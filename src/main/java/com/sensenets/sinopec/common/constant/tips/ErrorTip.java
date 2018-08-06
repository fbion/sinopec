package com.sensenets.sinopec.common.constant.tips;

import com.sensenets.sinopec.common.exception.BizExceptionEnum;


/**
  * @ClassName: ErrorTip
  * @Description: 返回给前台的错误提示
  * @author think
  * @date 2018年8月6日 下午3:15:23
  *
  */
public class ErrorTip extends Tip {

    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ErrorTip(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
    }
}
