/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月11日 下午2:55:37
 * @version V1.0
 */
package com.sensenets.sinopec.kafka.common;

import org.apache.commons.lang3.StringUtils;

/**
  * @ClassName: ConvertHelper
  * @Description: 转换工具
  * @author think
  * @date 2018年9月11日 下午2:55:37
  *
  */
public class ConvertHelper {
    
    
    public static Short str2Short(String data){
        return StringUtils.isNotBlank(data)?Short.parseShort(data):null;
    }
    
    public static Long str2Long(String data){
        return StringUtils.isNotBlank(data)?Long.parseLong(data):null;
    }
    
    public static Long int2Long(Integer data){
        return data!=null?Long.parseLong(String.valueOf(data)):null;
    }
    
    public static Integer short2Integer(Short data){
        return data!=null?Integer.parseInt(String.valueOf(data)):null;
    }
    
    public static String long2Str(Long data){
        return data!=null?String.valueOf(data):null;
    }
    
}
