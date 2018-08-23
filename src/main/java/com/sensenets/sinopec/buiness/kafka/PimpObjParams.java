/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月21日 上午10:20:19
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.kafka;

import dg.model.PimpObject;
import lombok.Data;

/**
  * @ClassName: PimpObjParams
  * @Description: 对象类型参数
  * @author think
  * @param <T>
  * @date 2018年8月21日 上午10:20:19
  *
  */
@Data
public class PimpObjParams<T> {
    
    private PimpObject.ObjectType  type ;
    
    private T  obj;
    
    public PimpObjParams(){
        
    }
    
    public PimpObjParams(PimpObject.ObjectType  type , T obj){
        this.type = type;
        this.obj = obj;
    }

}
