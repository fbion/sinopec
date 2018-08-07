package com.sensenets.sinopec.core.template.config;

import java.util.ArrayList;
import java.util.List;


/**
  * @ClassName: ControllerConfig
  * @Description: 控制器模板生成的配置
  * @author think
  * @date 2018年8月6日 下午2:27:27
  *
  */
public class ControllerConfig {

    private ContextConfig contextConfig;

    private String controllerPathTemplate;
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        
        imports.add("com.sensenets.sinopec.common.controller.BaseController");
        imports.add("lombok.extern.slf4j.Slf4j");
        
        imports.add("io.swagger.annotations.Api");
        imports.add("io.swagger.annotations.ApiOperation");
        imports.add("io.swagger.annotations.ApiResponse");
        imports.add("io.swagger.annotations.ApiResponses");
    
        imports.add("org.springframework.http.ResponseEntity");
        imports.add("org.springframework.http.HttpStatus");
        imports.add("org.springframework.stereotype.Controller");
        imports.add("org.springframework.web.bind.annotation.RequestMapping");
        imports.add("org.springframework.web.bind.annotation.ResponseBody");
        imports.add("org.springframework.web.bind.annotation.RestController");
        imports.add("org.springframework.web.bind.annotation.RequestMethod");
        imports.add("org.springframework.web.bind.annotation.PathVariable");
        
        imports.add("org.springframework.ui.Model");
        
        this.imports = imports;
        this.packageName = "com.sensenets.sinopec.buiness.controller";
        this.controllerPathTemplate = "\\src\\main\\java\\com\\sensenets\\sinopec\\buiness\\controller\\{}Controller.java";
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public String getControllerPathTemplate() {
        return controllerPathTemplate;
    }

    public void setControllerPathTemplate(String controllerPathTemplate) {
        this.controllerPathTemplate = controllerPathTemplate;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }
}
