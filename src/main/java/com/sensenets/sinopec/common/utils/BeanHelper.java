package com.sensenets.sinopec.common.utils;

import org.springframework.context.ApplicationContext;



/**
  * @ClassName: BeanHelper
  * @Description: bean帮助类
  * @author think
  * @date 2018年8月29日 下午6:05:20
  *
  */
public class BeanHelper {


    private static ApplicationContext context;

    /**
     * @Title: init
     * @Description: 初始化
     * @param context
     *            ApplicationContext
     */
    public static void init(ApplicationContext context) {
        BeanHelper.context = context;
    }

    /**
     * @Title: getBean
     * @Description: 获取bean
     * @param entityClass
     *            Class<T>
     * @param <T>
     *            <T>
     * @return T
     */
    public static <T> T getBean(Class<T> entityClass) {
        return context.getBean(entityClass);
    }
    
    /**
     * @Title: getBean
     * @Description: 获取bean
     * @param name
     *            String
     * @param entityClass
     *            Class<T>
     * @param <T>
     *            <T>
     * @return T
     */
    public static <T> T getBean(String name, Class<T> entityClass) {
        return context.getBean(name, entityClass);
    }

    

   
}
