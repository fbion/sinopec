package com.sensenets.sinopec.core.template.engine;

import com.sensenets.sinopec.core.support.ToolUtil;
import com.sensenets.sinopec.core.template.engine.base.BaseTemplateEngine;

/**
  * @ClassName: SimpleTemplateEngine
  * @Description: 通用模板生产引擎
  * @author think
  * @date 2018年8月6日 下午2:18:40
  *
  */
public class SimpleTemplateEngine extends BaseTemplateEngine {

    private static final String tmeplateFilePath = "templates/";
    
   
    @Override
    protected void generateController() {
        String controllerPath = ToolUtil.format(super.getContextConfig().getProjectPath() + super.getControllerConfig().getControllerPathTemplate(),
                ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
        generateFile(tmeplateFilePath+"Controller.java.btl", controllerPath);
        System.out.println("生成控制器成功!");
    }

    @Override
    protected void generateService() {
        String servicePath = ToolUtil.format(super.getContextConfig().getProjectPath() + super.getServiceConfig().getServicePathTemplate(),
                ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
        generateFile(tmeplateFilePath+"Service.java.btl", servicePath);
        System.out.println("生成Service成功!");

        String serviceImplPath = ToolUtil.format(super.getContextConfig().getProjectPath() + super.getServiceConfig().getServiceImplPathTemplate(),
                ToolUtil.firstLetterToUpper(super.getContextConfig().getBizEnName()));
        generateFile(tmeplateFilePath+"ServiceImpl.java.btl", serviceImplPath);
        System.out.println("生成ServiceImpl成功!");
    }
}
