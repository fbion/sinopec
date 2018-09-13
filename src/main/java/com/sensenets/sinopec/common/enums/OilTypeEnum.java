/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月28日 下午12:28:45
 * @version V1.0
 */
package com.sensenets.sinopec.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
  * @ClassName: OilTypeEnum
  * @Description: 油品类型枚举
  * @author think
  * @date 2018年8月28日 下午12:28:45
  */
public enum OilTypeEnum {
//    Oil_Type    000607020060205886  0号车用柴油(Ⅴ)   1
//    Oil_Type    000607020060514943  0号车用柴油(Ⅵ)   1
//    Oil_Type    000603040060206059  92号车用汽油(Ⅴ)  1
//    Oil_Type    000603040060206060  95号车用汽油(Ⅴ)  1
//    Oil_Type    000603040060209058  98号车用汽油(Ⅴ)  1
    
    oil_0_v("000607020060205886","0号车用柴油(Ⅴ)"),
    
    oil_0_vi("000607020060514943","0号车用柴油(Ⅵ)"),
    
    oil_92("000603040060206059","92号车用汽油(Ⅴ)"),
    
    oil_95("000603040060206060","95号车用汽油(Ⅴ)"),
    
    oil_98("000603040060209058","98号车用汽油(Ⅴ)");
    
    
    private String code;
    
    private String desc;
    
    private OilTypeEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }
    

    public static String  getDescByCode(String code){
        for(OilTypeEnum type : OilTypeEnum.values()){
            if(StringUtils.isNotBlank(code)&&type.getCode().endsWith(code)){
                return type.getDesc();
            }
        }
        return "未知";
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public static void main(String[] args) {
        System.out.println(getDescByCode(null));
    }

}
