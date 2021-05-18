package com.lyj.multidatasource.config;

import com.alibaba.fastjson.JSONObject;
import com.lyj.multidatasource.entity.ApolloESPO;
import com.lyj.multidatasource.entity.ApolloUPMPO;
import com.lyj.multidatasource.service.ApolloService;
import com.lyj.multidatasource.service.IUPMService;
import com.lyj.multidatasource.service.RealtimeESService;
import com.lyj.multidatasource.service.UPMServiceImpl;
import com.lyj.multidatasource.tool.SpringContainerTool;
import com.xiaoju.apollo.sdk.Apollo;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.List;

import static com.lyj.multidatasource.Constant.ApolloConstant.NAME_SPACE;
import static com.lyj.multidatasource.Constant.ApolloConstant.SAAS_CONFIG_NAME;

/**
 * @ClassName UPMBuilderFactory
 * @Description UPMBuilderFactory
 * @Author liyongjie
 * @Date 2021/5/17 3:19 下午
 */
@Service
public class BuilderFactory implements BeanFactoryPostProcessor {
    @SneakyThrows
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //从阿波罗获取所有多租户配置，实例化不同租户的ES、FUSION对象，注册到spring容器中
        Apollo.autoInit();
        String upmVal = ApolloService.getConfigValue(NAME_SPACE, SAAS_CONFIG_NAME, "upm");
        List<ApolloUPMPO> upmpoList = JSONObject.parseArray(upmVal, ApolloUPMPO.class);
        for (ApolloUPMPO upmpo : upmpoList) {
            UPMServiceImpl iupmService = new UPMServiceImpl(upmpo.getHost());
            configurableListableBeanFactory.registerSingleton("upmService"+upmpo.getTenant(),iupmService);
        }
        String esVal = ApolloService.getConfigValue(NAME_SPACE, SAAS_CONFIG_NAME, "es");
        List<ApolloESPO> espoList = JSONObject.parseArray(esVal, ApolloESPO.class);
        for (ApolloESPO espo : espoList) {
            RealtimeESService esService=new RealtimeESService(espo.getZjIndex(),espo.getStaffIndex(),espo.getHost());
            configurableListableBeanFactory.registerSingleton("esService"+espo.getTenant(),esService);
        }
    }
}
