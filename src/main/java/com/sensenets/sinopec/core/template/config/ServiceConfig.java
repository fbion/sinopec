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

    private List<String> serviceImplImports;

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("org.springframework.stereotype.Service");
        imports.add("com.sensenets.sinopec.buiness." + contextConfig.getModuleName() + ".service.I" + contextConfig.getBizEnBigName() + "Service");
        this.serviceImplImports = imports;
        this.servicePathTemplate = "\\src\\main\\java\\com\\sensenets\\sinopec\\buiness\\" + contextConfig.getModuleName() + "\\service\\I{}Service.java";
        this.serviceImplPathTemplate = "\\src\\main\\java\\com\\sensenets\\sinopec\\buiness\\" + contextConfig.getModuleName() + "\\service\\impl\\{}ServiceImpl.java";
        this.packageName = "com.sensenets.sinopec.buiness." + contextConfig.getModuleName() + ".service";
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

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }
}
