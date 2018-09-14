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
    
    oil_0_v("000607020060205886","0号车用柴油(Ⅴ)",(short)2),
    
    oil_0_vi("000607020060514943","0号车用柴油(Ⅵ)",(short)2),
    
    oil_92("000603040060206059","92号车用汽油(Ⅴ)",(short)1),
    
    oil_95("000603040060206060","95号车用汽油(Ⅴ)",(short)1),
    
    oil_98("000603040060209058","98号车用汽油(Ⅴ)",(short)1);
    
    
    private String code;
    
    private String desc;
    
    private Short type;
    
    private OilTypeEnum(String code,String desc,Short type){
        this.code = code;
        this.desc = desc;
        this.type = type;
    }
    

    public static String  getDescByCode(String code){
        for(OilTypeEnum type : OilTypeEnum.values()){
            if(StringUtils.isNotBlank(code)&&type.getCode().endsWith(code)){
                return type.getDesc();
            }
        }
        return "未知";
    }
    
    public static Short  getTypeByCode(String code){
        for(OilTypeEnum type : OilTypeEnum.values()){
            if(StringUtils.isNotBlank(code)&&type.getCode().endsWith(code)){
                return type.getType();
            }
        }
        return null;
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
    
    
    
    public Short getType() {
        return type;
    }


    public void setType(Short type) {
        this.type = type;
    }


    public static void main(String[] args) {
        System.out.println(getDescByCode(null));
    }

}
