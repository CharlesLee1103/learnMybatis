package com.lyj.multidatasource.tool;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: liujiaxuan_i
 * @Email: liujiaxuan_i@didiglobal.com
 * @Date: 2021/4/6 下午3:57
 */
@Component
public class SpringContainerTool implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContainerTool.applicationContext == null) {
            SpringContainerTool.applicationContext=applicationContext;
        }
    }

    /**
     * 获取ApplicationContext容器
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取bean实例
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
}
