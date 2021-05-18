package com.lyj.multidatasource.config;

import com.lyj.multidatasource.service.RealtimeESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ESContext
 * @Description ESContext
 * @Author liyongjie
 * @Date 2021/5/18 2:14 下午
 */
@Service
public class ESContext  {
    @Resource
    private final Map<String, RealtimeESService> esServiceMap = new ConcurrentHashMap<>();
    @Resource
    private RealtimeESService esServicedidi;

    public String getInfo(){
        return getBean().getInfo();
    }

    public String setZjIndex(){
        return getBean().getZjIndex();
    }


    private RealtimeESService getBean(){
        return esServiceMap.getOrDefault("esService"+LoginContext.getLoginUser().getTenant(),esServicedidi);
    }


}
