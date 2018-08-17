/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月17日 上午10:32:52
 * @version V1.0
 */
package com.sensenets.sinopec.common.enums;

/**
  * @ClassName: UrlMethod
  * @Description: url方法类型枚举
  * @author think
  * @date 2018年8月17日 上午10:32:52
  *
  */
public enum UrlMethod {
    
    POST,GET,PUT,DELETE,ALL;
    
    public static UrlMethod getEnumType(String enumStr){
        for (UrlMethod c : UrlMethod.values()) {
            if (c.toString().equals(enumStr)) {
                return c;
            }
        }
        return null;
    }
}
