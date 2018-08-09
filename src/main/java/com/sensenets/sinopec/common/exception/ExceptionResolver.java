package com.sensenets.sinopec.common.exception;

import com.sensenets.sinopec.common.domain.ResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
  * @ClassName: ExceptionResolver
  * @Description: 全局异常处理
  * @author think
  * @date 2018年8月9日 上午9:59:31
  *
  */
@ControllerAdvice
@ResponseBody
public class ExceptionResolver {

    private ResponseInfo generateInfo(BaseException e){
        ResponseInfo info = new ResponseInfo();
        info.setCode(e.getErrorCode());
        info.setMessage(e.getErrorMsg());
        info.setStatus(ResponseInfo.Status.ERROR);
        info.setError(e.getMessage());
        return info;
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseInfo serviceCommonExceptionHandler(BusinessException e) {
        return generateInfo(e);
    }
    
    @ExceptionHandler(value = SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseInfo systemCommonExceptionHandler(SystemException e) {
        return generateInfo(e);
    }
    
    @ExceptionHandler(value = ToolInitException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  ResponseInfo toolInitCommonExceptionHandler(ToolInitException e) {
        return generateInfo(e);
    }

    
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ResponseInfo commonExceptionHandler(Exception e) {
        ResponseInfo info = new ResponseInfo();
        info.setCode(500);
        info.setMessage("操作失败");
        info.setStatus(ResponseInfo.Status.ERROR);
        info.setError(e.getMessage());
        return info;
    }
    

}