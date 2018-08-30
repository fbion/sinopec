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
  * @ClassName: DeleteStatusEnum
  * @Description: 删除状态枚举
  * @author think
  * @date 2018年8月28日 下午12:28:45
  *
  */
public enum DeleteStatusEnum {
    
    EXIST((short)1),
    
    DELETE((short)4);
    
    private short code;
    
    private DeleteStatusEnum(short code){
        this.code = code;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }
    
    

}
