package com.sensenets.sinopec.common.constant.state;


/**
  * @ClassName: LogSucceed
  * @Description: 业务是否成功的日志记录
  * @author think
  * @date 2018年8月6日 下午3:13:25
  *
  */
public enum LogSucceed {

    SUCCESS("成功"),
    FAIL("失败");

    String message;

    LogSucceed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
