package com.sensenets.sinopec.core.template.config;

import java.util.ArrayList;
import java.util.List;


/**
  * @ClassName: ServiceConfig
  * @Description: Service模板生成的配置
  * @author think
  * @date 2018年8月6日 下午2:21:41
  *
  */
public class ServiceConfig {

    private ContextConfig contextConfig;

    private String servicePathTemplate;
    private String serviceImplPathTemplate;

    private String packageName;

    private List<String> serviceImports;
    private List<String> serviceImplImports;

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("com.github.pagehelper.PageInfo");
        imports.add("com.sensenets.sinopec.buiness.condition.CommonCondition");
        imports.add("com.sensenets.sinopec.buiness.model."+contextConfig.getBizEnBigName()+"");
        imports.add("java.util.List");
        
        this.serviceImports = imports;
        
        ArrayList<String> implImports = new ArrayList<>();
        implImports.add("org.springframework.stereotype.Service");
        implImports.add("com.sensenets.sinopec.buiness.service.I" + contextConfig.getBizEnBigName() + "Service");
        implImports.add("com.github.pagehelper.PageInfo");
        implImports.add("com.sensenets.sinopec.buiness.condition.CommonCondition");
        
        implImports.add("com.sensenets.sinopec.buiness.condition."+contextConfig.getBizEnBigName()+"Condition");
        
        implImports.add("com.sensenets.sinopec.buiness.model."+contextConfig.getBizEnBigName()+"");
        implImports.add("com.sensenets.sinopec.buiness.dao."+contextConfig.getBizEnBigName()+"Mapper");
        implImports.add("java.util.List");
        implImports.add("org.apache.commons.lang3.StringUtils");
        implImports.add("org.springframework.beans.factory.annotation.Autowired");
        implImports.add("com.github.pagehelper.PageHelper");
        implImports.add("com.github.pagehelper.PageInfo");
        
        
        this.serviceImplImports = implImports;
        
        
        this.servicePathTemplate = "\\src\\main\\java\\com\\sensenets\\sinopec\\buiness\\service\\I{}Service.java";
        this.serviceImplPathTemplate = "\\src\\main\\java\\com\\sensenets\\sinopec\\buiness\\service\\impl\\{}ServiceImpl.java";
        this.packageName = "com.sensenets.sinopec.buiness.service";
    }


    public String getServicePathTemplate() {
        return servicePathTemplate;
    }

    public void setServicePathTemplate(String servicePathTemplate) {
        this.servicePathTemplate = servicePathTemplate;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getServiceImplPathTemplate() {
        return serviceImplPathTemplate;
    }

    public void setServiceImplPathTemplate(String serviceImplPathTemplate) {
        this.serviceImplPathTemplate = serviceImplPathTemplate;
    }

    public List<String> getServiceImplImports() {
        return serviceImplImports;
    }

    public void setServiceImplImports(List<String> serviceImplImports) {
        this.serviceImplImports = serviceImplImports;
    }
    
    public List<String> getServiceImports() {
        return serviceImports;
    }

    public void setServiceImports(List<String> serviceImports) {
        this.serviceImports = serviceImports;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }
}
