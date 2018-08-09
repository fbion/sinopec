
package com.sensenets.sinopec.common.exception;

import com.sensenets.sinopec.core.support.StrKit;
import lombok.Data;


/**
  * @ClassName: ToolInitException
  * @Description: 工具类初始化异常
  * @author think
  * @date 2018年8月9日 上午10:19:45
  *
  */
@Data
public class ToolInitException extends BaseException{
	private static final long serialVersionUID = 8247610319171014183L;

    public ToolInitException(Integer code) {
        super();
        this.errorCode = code;
    }

    public ToolInitException(Integer code, String message) {
        super();
        this.errorCode = code;
        this.errorMsg = message;
    }

    public ToolInitException(Integer code, String message, Throwable cause) {
        super(cause);
        this.errorCode = code;
        this.errorMsg = message;
    }

    public ToolInitException(Throwable e) {
        super(e.getMessage(), e);
    }

    public ToolInitException(String message) {
        super(message);
    }

    public ToolInitException(String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params));
    }

    public ToolInitException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ToolInitException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params), throwable);
    }

}
