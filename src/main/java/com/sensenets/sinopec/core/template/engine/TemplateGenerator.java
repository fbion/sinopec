package com.sensenets.sinopec.core.template.engine;

import java.io.IOException;

import com.sensenets.sinopec.core.template.config.ContextConfig;
import com.sensenets.sinopec.core.template.engine.SimpleTemplateEngine;
import com.sensenets.sinopec.core.template.engine.base.BaseTemplateEngine;


/**
  * @ClassName: TemplateGenerator
  * @Description: 测试模板引擎
  * @author think
  * @date 2018年8月6日 下午3:11:36
  *
  */
public class TemplateGenerator {

    public static void main(String[] args) throws IOException {
        ContextConfig contextConfig = new ContextConfig();
        contextConfig.setBizChName("移动数据采集");
        contextConfig.setBizEnName("mobileCollectTask");
        contextConfig.setModuleName("mobileCollectTask");
        contextConfig.setProjectPath("D:\\project\\sinopec");
        // 不生成Dao
        contextConfig.setDaoSwitch(false);
        BaseTemplateEngine gunsTemplateEngine = new SimpleTemplateEngine();
        gunsTemplateEngine.setContextConfig(contextConfig);
        gunsTemplateEngine.start();
    }

}
