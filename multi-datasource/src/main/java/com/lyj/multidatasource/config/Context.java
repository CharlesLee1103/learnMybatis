package com.lyj.multidatasource.config;

import com.lyj.multidatasource.service.RealtimeESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName Context
 * @Description Context
 * @Author liyongjie
 * @Date 2021/5/18 3:23 下午
 */
@Service
public class Context extends AbstractContext<RealtimeESService> {

//    @Resource
//    Map<String, RealtimeESService> esServiceMap = new ConcurrentHashMap<>();

    public Context(Map<String, RealtimeESService> esServiceMap,@Qualifier("esServicedidi") RealtimeESService servicedidi) {
//        this.esServiceMap = esServiceMap;
        super.serviceMap=esServiceMap;
        super.servicedidi=servicedidi;
    }

    public String getInfo(){
        return getBean().getInfo();
    }

    private RealtimeESService getBean() {
        return super.getBean("es");
    }
}
