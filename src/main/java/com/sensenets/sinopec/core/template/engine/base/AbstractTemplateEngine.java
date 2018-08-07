package com.sensenets.sinopec.core.template.engine.base;

import com.sensenets.sinopec.core.template.config.ContextConfig;
import com.sensenets.sinopec.core.template.config.ControllerConfig;
import com.sensenets.sinopec.core.template.config.DaoConfig;
import com.sensenets.sinopec.core.template.config.ServiceConfig;


/**
  * @ClassName: AbstractTemplateEngine
  * @Description: 模板生成父类
  * @author think
  * @date 2018年8月6日 下午2:19:19
  *
  */
public class AbstractTemplateEngine {

    protected ContextConfig contextConfig;                //全局配置
    protected ControllerConfig controllerConfig;          //控制器的配置
    protected ServiceConfig serviceConfig;                //Service配置
    protected DaoConfig daoConfig;                        //Dao配置

    public void initConfig() {
        if (this.contextConfig == null) {
            this.contextConfig = new ContextConfig();
        }
        if (this.controllerConfig == null) {
            this.controllerConfig = new ControllerConfig();
        }
        if (this.serviceConfig == null) {
            this.serviceConfig = new ServiceConfig();
        }
        
        if (this.daoConfig == null) {
            this.daoConfig = new DaoConfig();
        }

        this.controllerConfig.setContextConfig(this.contextConfig);
        this.controllerConfig.init();

        this.serviceConfig.setContextConfig(this.contextConfig);
        this.serviceConfig.init();
        
        this.daoConfig.setContextConfig(this.contextConfig);
        this.daoConfig.init();
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }

    public ControllerConfig getControllerConfig() {
        return controllerConfig;
    }

    public void setControllerConfig(ControllerConfig controllerConfig) {
        this.controllerConfig = controllerConfig;
    }

    public ServiceConfig getServiceConfig() {
        return serviceConfig;
    }

    public void setServiceConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    public DaoConfig getDaoConfig() {
        return daoConfig;
    }

    public void setDaoConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }
    
    
}

