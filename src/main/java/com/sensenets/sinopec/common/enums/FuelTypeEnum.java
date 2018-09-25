/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月28日 下午12:28:45
 * @version V1.0
 */
package com.sensenets.sinopec.common.enums;

/**
  * @ClassName: FuelTypeEnum
  * @Description: 燃油类型枚举
  * @author think
  * @date 2018年8月28日 下午12:28:45
  */
public enum FuelTypeEnum {

    
   qiyou("汽油",(short)1),
   chaiyou("柴油",(short)2),
   unknown("未知",(short)0);
    
    private String desc;
    
    private Short type;
    
    private FuelTypeEnum(String desc,Short type){
        this.desc = desc;
        this.type = type;
    }
    

    public static String  getDescByType(Short type){
        for(FuelTypeEnum fuelType : FuelTypeEnum.values()){
            if(type!=null&&fuelType.getType() == type){
                return fuelType.getDesc();
            }
        }
        return unknown.desc;
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
        System.out.println(getDescByType((short)1));
    }

}
