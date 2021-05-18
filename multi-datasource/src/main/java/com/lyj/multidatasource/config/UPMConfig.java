package com.lyj.multidatasource.config;

import com.lyj.multidatasource.service.IUPMService;
import com.lyj.multidatasource.service.UPMServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UPMConfig
 * @Description UPMConfig
 * @Author liyongjie
 * @Date 2021/5/17 2:07 下午
 */
@Configuration
public class UPMConfig {
    @Value("${upm.host}")
    private String host;
    @Value("${upm.host2}")
    private String host2;
    @Bean("upmService"+"didi")
    public IUPMService getUPMService(){
        return new UPMServiceImpl(host);
    }
    @Bean("upmService"+"cx")
    public IUPMService getUPMService2(){
        return new UPMServiceImpl(host2);
    }
}
