package com.sensenets.sinopec.core.template.config;


/**
  * @ClassName: DaoConfig
  * @Description: Dao模板生成的配置
  * @author think
  * @date 2018年8月7日 上午9:50:49
  *
  */
public class DaoConfig {

    private ContextConfig contextConfig;

    private String daoPathTemplate;
    private String xmlPathTemplate;

    private String packageName;

    public void init() {
        this.daoPathTemplate = "\\src\\main\\java\\com\\sensenets\\sinopec\\buiness\\dao\\{}Dao.java";
        this.xmlPathTemplate = "\\src\\main\\resources\\mapper\\{}Dao.xml";
        this.packageName = "com.sensenets.sinopec.buiness.dao";
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDaoPathTemplate() {
        return daoPathTemplate;
    }

    public void setDaoPathTemplate(String daoPathTemplate) {
        this.daoPathTemplate = daoPathTemplate;
    }

    public String getXmlPathTemplate() {
        return xmlPathTemplate;
    }

    public void setXmlPathTemplate(String xmlPathTemplate) {
        this.xmlPathTemplate = xmlPathTemplate;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }
}
