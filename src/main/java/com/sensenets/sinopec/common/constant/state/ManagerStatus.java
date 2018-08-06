package com.sensenets.sinopec.common.constant.state;


/**
  * @ClassName: ManagerStatus
  * @Description: 管理员的状态
  * @author think
  * @date 2018年8月6日 下午3:14:09
  *
  */
public enum ManagerStatus {

    OK(1, "启用"), FREEZED(2, "冻结"), DELETED(3, "被删除");

    int code;
    String message;

    ManagerStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return "";
        } else {
            for (ManagerStatus ms : ManagerStatus.values()) {
                if (ms.getCode() == value) {
                    return ms.getMessage();
                }
            }
            return "";
        }
    }
}
