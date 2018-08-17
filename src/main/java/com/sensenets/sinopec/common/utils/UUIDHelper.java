package com.sensenets.sinopec.common.utils;

import java.util.UUID;


/**
  * @ClassName: UUIDHelper
  * @Description: uuid工具
  * @author think
  * @date 2018年8月17日 下午3:20:41
  *
  */
public class UUIDHelper {

   
    /**
      * @Title: genUUID
      * @Description: 生成uuid
      * @param isUpper 是否大写
      * @return
      */
    public static String genUUID(boolean isUpper) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return isUpper?uuid.toUpperCase():uuid.toLowerCase();
    }
    
    /**
     * @Title: genSourceUUID
     * @Description: 生成原始uuid
     * @param isUpper 是否大写
     * @return
     */
   public static String genSourceUUID(boolean isUpper) {
       String uuid = UUID.randomUUID().toString();
       return isUpper?uuid.toUpperCase():uuid.toLowerCase();
   }
   
   public static void main(String[] args) {
      System.out.println(genUUID(false));
      System.out.println(genSourceUUID(false));
   }
    
}
