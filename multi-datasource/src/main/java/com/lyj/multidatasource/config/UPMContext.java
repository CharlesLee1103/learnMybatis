package com.lyj.multidatasource.config;

import com.lyj.multidatasource.service.IUPMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName UPMContext
 * @Description UPMContext
 * @Author liyongjie
 * @Date 2021/5/17 2:39 下午
 */
@Service
public class UPMContext implements IUPMService {
    @Autowired
    private final Map<String, IUPMService> upmServiceMap = new ConcurrentHashMap<>();
    @Resource
    private IUPMService upmServicedidi;


    @Override
    public String getRole(String tenantId) {
        return upmServiceMap.getOrDefault("upmService"+LoginContext.getLoginUser().getTenant(),upmServicedidi).getRole(tenantId);
    }


}
