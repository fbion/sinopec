/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月30日 下午5:55:18
 * @version V1.0
 */
package com.sensenets.sinopec.common.enums;

/**
  * @ClassName: CollectTaskTypeEnum
  * @Description: 采集任务类型枚举
  * @author think
  * @date 2018年8月30日 下午5:55:18
  *
  */
public enum CollectTaskTypeEnum {
    
    InStation((short)1),
    
    OutStation((short)2),
    
    ALL((short)3);
    
    private short code;
    
    private CollectTaskTypeEnum(short code){
        this.code = code;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }
    

}
