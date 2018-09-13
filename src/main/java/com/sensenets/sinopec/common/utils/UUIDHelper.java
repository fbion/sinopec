package com.sensenets.sinopec.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;


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
   
   public static void main(String[] args) throws IOException {
      System.out.println(genUUID(false));
      System.out.println(genSourceUUID(false));
      String image = "D:\\tmp\\12.jpg";
//      System.out.println(Base64AllHelper.encodeBytes(FileUtils.readFileToByteArray(new File(image))));
      System.out.println(System.currentTimeMillis());
      System.out.println(System.currentTimeMillis());
   }
    
}
