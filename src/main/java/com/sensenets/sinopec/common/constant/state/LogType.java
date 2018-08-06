package com.sensenets.sinopec.common.constant.state;


/**
  * @ClassName: LogType
  * @Description: 日志类型
  * @author think
  * @date 2018年8月6日 下午3:13:45
  *
  */
public enum LogType {

    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志"),
    EXIT("退出日志"),
    EXCEPTION("异常日志"),
    BUSSINESS("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
