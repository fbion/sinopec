package com.sensenets.sinopec.common.warpper;

/**
  * @ClassName: BaseControllerWarpper
  * @Description: 控制器查询结果的包装类基类
  * @author think
  * @date 2018年8月6日 下午4:22:37
  *
  */
public abstract class BaseControllerWarpper {

    public Object obj = null;

    public BaseControllerWarpper(Object obj) {
        this.obj = obj;
    }

    public Object warp() {
       return this.obj;
    }
    
    
}
