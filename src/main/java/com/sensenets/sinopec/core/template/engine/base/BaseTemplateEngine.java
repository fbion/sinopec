package com.sensenets.sinopec.core.template.engine.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import com.sensenets.sinopec.core.support.ToolUtil;
import com.sun.javafx.PlatformUtil;


/**
  * @ClassName: BaseTemplateEngine
  * @Description: 模板生成 引擎
  * @author think
  * @date 2018年8月6日 下午2:19:04
  *
  */
public abstract class BaseTemplateEngine extends AbstractTemplateEngine {

    protected GroupTemplate groupTemplate;

    public BaseTemplateEngine() {
        initBeetlEngine();
    }

    public void initBeetlEngine() {
        Properties properties = new Properties();
        properties.put("RESOURCE.root", "");
        properties.put("DELIMITER_STATEMENT_START", "<%");
        properties.put("DELIMITER_STATEMENT_END", "%>");
        properties.put("HTML_TAG_FLAG", "##");
        Configuration cfg = null;
        try {
            cfg = new Configuration(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        groupTemplate = new GroupTemplate(resourceLoader, cfg);
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
    }

    public void configTemplate(Template template){
        template.binding("context", super.getContextConfig());
        template.binding("controller", super.getControllerConfig());
        template.binding("service", super.getServiceConfig());
        template.binding("dao", super.getDaoConfig());
    }

    public void generateFile(String template,String filePath){
        Template pageTemplate = groupTemplate.getTemplate(template);
        configTemplate(pageTemplate);
        if(PlatformUtil.isLinux()){
            filePath = filePath.replaceAll("/+|\\\\+","/");
        }else{
            filePath = filePath.replaceAll("/+|\\\\+","\\\\");
        }
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        try {
            pageTemplate.renderTo(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        //配置之间的相互依赖
        super.initConfig();

        //生成模板
        if(super.contextConfig.getControllerSwitch()){
            generateController();
        }
        if(super.contextConfig.getServiceSwitch()){
            generateService();
        }
        if(super.contextConfig.getDaoSwitch()){
            generateDao();
        }

    }

    protected abstract void generateController();

    protected abstract void generateService();
    
    protected abstract void generateDao();

}
