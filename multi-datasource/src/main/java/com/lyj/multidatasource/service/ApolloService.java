package com.lyj.multidatasource.service;

import com.alibaba.fastjson.JSONObject;
import com.lyj.multidatasource.entity.ApolloUPMPO;
import com.sun.javafx.binding.StringFormatter;
import com.xiaoju.apollo.sdk.Apollo;
import com.xiaoju.apollo.sdk.model.api.Condition;
import com.xiaoju.apollo.sdk.model.api.Config;
import com.xiaoju.apollo.sdk.model.api.ConfigValue;
import com.xiaoju.apollo.sdk.model.api.NamespaceConfig;

import java.util.*;

import static com.lyj.multidatasource.Constant.ApolloConstant.NAME_SPACE;
import static com.lyj.multidatasource.Constant.ApolloConstant.SAAS_CONFIG_NAME;

/**
 * @ClassName ApolloService
 * @Description ApolloService
 * @Author liyongjie
 * @Date 2021/5/17 7:35 下午
 */
public class ApolloService {
    public static void main(String[] args) throws Exception {

        Apollo.autoInit();  //初始化Apollo
        String namespace = "kefuqc";
        String configName = "saas";
        //获得配置中指定参数的value
        String value = getConfigValue(NAME_SPACE, SAAS_CONFIG_NAME, "upm");
        List<ApolloUPMPO> upmpoList= JSONObject.parseArray(value, ApolloUPMPO.class);
        System.out.println(value);

        //根据类型获取配置中的指定参数value
        Integer timeout = getIntConfigValue(namespace, configName, "timeout");
        System.out.println(timeout);

        //获得配置所有参数的key-value信息
        Map<String, String> keyAndValuePairs = getConfigValues(namespace, configName);
        System.out.println(keyAndValuePairs);

        // 获取指定 namespace 下所有配置（从所有 Config 中获取 Key-Value 参考上面方法 ）
        Collection<Config> configsByNamespace = getConfigsByNamespace(namespace);

        //根据条件获取一个 namespace 下的所有配置(仅用于运营模板配置)
        Condition condition = new Condition();
        condition.with("key", "value");
        Collection<Config> configsByNamespaceAndConditions = getConfigsByNamespaceAndConditions(namespace, condition);

        //关闭
        Apollo.close();
    }

    public static String getConfigValue(String namespace, String configName, String key) {
        //配置同步服务使用namespace+configName作为唯一标识，获得该配置指定key的value
        ConfigValue<String> configValue = Apollo.getConfigValue(namespace, configName, key);
        //首先验证获得的参数执行结果是否可用，configValue.valid() 表示可用，否则不可用， 详见 ConfigValue 说明
        if (configValue.valid()) {
            return configValue.value();
        } else {
            System.out.println(StringFormatter.format("not find where namespace = %s, configName = %s, key = %s", namespace, configName, key));
        }
        return "";
    }

    public static Integer getIntConfigValue(String namespace, String configName, String key) {
        //配置同步服务使用namespace+configName作为唯一标识，获得该配置指定key的value, 支持传入 value 类型
        ConfigValue<Integer> configValue = Apollo.getConfigValue(namespace, configName, key, Integer.class);
        //首先验证获得的参数执行结果是否可用，configValue.valid() 表示可用，否则不可用， 详见 ConfigValue 说明
        if (configValue.valid()) {
            return configValue.value();
        } else {
            System.out.println(StringFormatter.format("not find where namespace = %s, configName = %s, key = %s", namespace, configName, key));
        }
        return null;
    }


    public static Map<String, String> getConfigValues(String namespace, String configName) {
        //配置同步服务使用namespace+configName作为唯一标识，获得所有的配置参数
        Config config = Apollo.getConfig(namespace, configName);
        //首先验证获得的参数执行结果是否可用，config.valid() 表示可用，否则不可用，详见Config说明
        if (config.valid()) {
            return config.stringValues();
        } else {
            System.out.println(StringFormatter.format("not find where namespace = %s, configName = %s", namespace, configName));
        }
        return new HashMap<>();
    }

    public static Collection<Config> getConfigsByNamespace(String namespace)  {
        //获取指定 namespace
        NamespaceConfig namespaceConfig = Apollo.getConfigsByNamespace(namespace);
        //首先验证获得的参数执行结果是否可用，namespaceConfig.valid() 表示可用，否则不可用
        if (namespaceConfig.valid()) {
            return namespaceConfig.getAllConfigs();
        } else {
            System.out.println(StringFormatter.format("not find where namespace = %s", namespace));
        }
        return new ArrayList<>();
    }

    public static Collection<Config> getConfigsByNamespaceAndConditions(String namespace, Condition condition) {
        //获取指定 namespace 下匹配conditions的配置
        NamespaceConfig namespaceConfig = Apollo.getConfigsByNamespaceAndConditions(namespace, condition);
        //首先验证获得的参数执行结果是否可用，namespaceConfig.valid() 表示可用，否则不可用
        if (namespaceConfig.valid()) {
            return namespaceConfig.getAllConfigs();
        } else {
            System.out.println(StringFormatter.format("not find where namespace = %s, conditions = %s", namespace, condition));
        }
        return new ArrayList<>();
    }

}
