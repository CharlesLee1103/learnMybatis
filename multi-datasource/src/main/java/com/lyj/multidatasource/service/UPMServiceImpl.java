package com.lyj.multidatasource.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName UPMServiceImpl
 * @Description UPMServiceImpl
 * @Author liyongjie
 * @Date 2021/5/17 12:00 下午
 */
@Slf4j
public class UPMServiceImpl implements IUPMService {

    private String host;

    public UPMServiceImpl(String host) {
        this.host = host;
    }

    @Override
    public String getRole(String tenantId) {
        String x = host + "  " + tenantId;
        log.info(x);
        return x;
    }
}
