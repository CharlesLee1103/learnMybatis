package com.lyj.multidatasource.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RealtimeESService
 * @Description RealtimeESService
 * @Author liyongjie
 * @Date 2021/5/18 11:39 上午
 */
@Slf4j
@Data
public class RealtimeESService {
    public String zjIndex;
    public String staffIndex;

    public RealtimeESService(String zjIndex, String staffIndex, String host) {
        this.zjIndex = zjIndex;
        this.staffIndex = staffIndex;
        this.host = host;
    }

    public String host;
    public String getInfo(){
        String info = host + " " + zjIndex + " staffIndex=" + staffIndex;
        log.info(info);
        return info;
    }

}
