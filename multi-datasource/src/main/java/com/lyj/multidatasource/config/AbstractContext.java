package com.lyj.multidatasource.config;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName AbstractContext
 * @Description AbstractContext
 * @Author liyongjie
 * @Date 2021/5/18 3:05 下午
 */
//@Service
public class AbstractContext<T> {
//    @Resource
    protected  Map<String, T> serviceMap = new ConcurrentHashMap<>();
//    @Resource
    protected T servicedidi;

    protected T getBean(String prefix){
        return serviceMap.getOrDefault(prefix + "Service" + LoginContext.getLoginUser().getTenant(), servicedidi);
    }
}
