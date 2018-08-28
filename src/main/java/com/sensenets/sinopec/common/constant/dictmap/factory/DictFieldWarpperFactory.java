package com.sensenets.sinopec.common.constant.dictmap.factory;

import java.lang.reflect.Method;

import com.sensenets.sinopec.common.constant.factory.ConstantFactory;
import com.sensenets.sinopec.common.constant.factory.IConstantFactory;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.exception.BusinessException;


/**
  * @ClassName: DictFieldWarpperFactory
  * @Description: 字段的包装创建工厂
  * @author think
  * @date 2018年8月6日 下午3:20:09
  *
  */
public class DictFieldWarpperFactory {

    public static Object createFieldWarpper(Object field, String methodName) {
        IConstantFactory me = ConstantFactory.me();
        try {
            Method method = IConstantFactory.class.getMethod(methodName, field.getClass());
            Object result = method.invoke(me, field);
            return result;
        } catch (Exception e) {
            try {
                Method method = IConstantFactory.class.getMethod(methodName, Integer.class);
                Object result = method.invoke(me, Integer.parseInt(field.toString()));
                return result;
            } catch (Exception e1) {
                throw new BusinessException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
            }
        }
    }

}
