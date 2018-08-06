package com.sensenets.sinopec.common.warpper;

import java.util.List;
import java.util.Map;

import com.sensenets.sinopec.common.utils.JsonHelper;


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
        if (this.obj instanceof List) {
            return JsonHelper.toJson(this.obj);
        } else if (this.obj instanceof Map) {
            return JsonHelper.toJson(this.obj);
        } else {
            return JsonHelper.toJson(this.obj);
        }
    }
    
    
}
