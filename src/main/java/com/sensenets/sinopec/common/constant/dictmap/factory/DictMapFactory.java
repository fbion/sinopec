package com.sensenets.sinopec.common.constant.dictmap.factory;

import com.sensenets.sinopec.common.constant.dictmap.base.AbstractDictMap;
import com.sensenets.sinopec.common.constant.dictmap.base.SystemDict;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.exception.BusinessException;


/**
  * @ClassName: DictMapFactory
  * @Description: 字典的创建工厂
  * @author think
  * @date 2018年8月6日 下午3:19:20
  *
  */
public class DictMapFactory {

    private static final String basePath = "com.sensenets.sinopec.common.constant.dictmap.";

    /**
     * 通过类名创建具体的字典类
     */
    public static AbstractDictMap createDictMap(String className) {
        if("SystemDict".equals(className)){
            return new SystemDict();
        }else{
            try {
                Class<AbstractDictMap> clazz = (Class<AbstractDictMap>) Class.forName(basePath + className);
                return clazz.newInstance();
            } catch (Exception e) {
                throw new BusinessException(BizExceptionEnum.ERROR_CREATE_DICT);
            }
        }
    }
}
