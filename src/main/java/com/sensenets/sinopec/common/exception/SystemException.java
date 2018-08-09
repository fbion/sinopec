package com.sensenets.sinopec.common.exception;

import com.sensenets.sinopec.core.support.StrKit;

import lombok.Data;

/**
  * @ClassName: SystemException
  * @Description: 系统异常
  * @author think
  * @date 2018年8月9日 上午10:08:14
  *
  */
@Data
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 8882366904034518521L;

    /**
     * @Fields errorCode : 错误码
     */
   private int errorCode;

   /**
     * @Fields errorMsg : 错误提示信息
     */
   private String errorMsg;
   
   /**
     * @Fields urlPath : 业务异常跳转的页面
     */
   private String urlPath;
   
   public SystemException(BizExceptionEnum bizExceptionEnum){
       super();
       this.errorCode = bizExceptionEnum.getCode();
       this.errorMsg = bizExceptionEnum.getMessage();
       this.urlPath = bizExceptionEnum.getUrlPath();
   }
   
   public SystemException(BizExceptionEnum bizExceptionEnum,Throwable e){
       super(e);
       this.errorCode = bizExceptionEnum.getCode();
       this.errorMsg = bizExceptionEnum.getMessage();
       this.urlPath = bizExceptionEnum.getUrlPath();
   }
   

   public SystemException(Throwable e) {
       super(e.getMessage(), e);
   }
   
   public SystemException(String message) {
       super(message);
   }
   
   public SystemException(String messageTemplate, Object... params) {
       super(StrKit.format(messageTemplate, params));
   }
   
   public SystemException(String message, Throwable throwable) {
       super(message, throwable);
   }
   
   public SystemException(Throwable throwable, String messageTemplate, Object... params) {
       super(StrKit.format(messageTemplate, params), throwable);
   }
}