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
  *分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，
  * 5:移动采集，6:进店抓拍机，7:客户收银抓拍机，8:出店抓拍机，9:内部收银抓拍机
  */
public enum SensorGroupEnum {
    
    sensor_out((short)1,"站外摄像机"),
    
    sensor_come((short)2,"进站摄像机"),
    
    sensor_oil((short)3,"加油摄像机"),
    
    sensor_exit((short)4,"出站摄像机"),
    
    sensor_collect_come((short)5,"移动采集进站"),
    
    sensor_come_shop((short)6,"进店抓拍机"),
    
    sensor_customer_cashier((short)7,"客户收银抓拍机"),
    
    sensor_exit_shop((short)8,"出店抓拍机"),
    
    sensor_inside_cashier((short)9,"内部收银抓拍机"),
    
    sensor_collect_out((short)10,"移动采集站外");
    
    
    private short code;
    
    private String desc;
    
    private SensorGroupEnum(short code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    

}
