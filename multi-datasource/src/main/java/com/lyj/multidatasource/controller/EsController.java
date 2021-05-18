package com.lyj.multidatasource.controller;

import com.lyj.multidatasource.config.AbstractContext;
import com.lyj.multidatasource.config.Context;
import com.lyj.multidatasource.config.ESContext;
import com.lyj.multidatasource.config.LoginContext;
import com.lyj.multidatasource.service.RealtimeESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EsController
 * @Description EsController
 * @Author liyongjie
 * @Date 2021/5/18 2:42 下午
 */
@RestController
@RequestMapping("/es")
public class EsController {
    @Autowired
    private ESContext esContext;
    @Autowired
    private Context context;
    @GetMapping("/get")
    public Object get(String tenant){
        LoginContext.setLoginUser(LoginContext.LoginUser.builder().ssoName("lyj").tenant(tenant).build());
        return esContext.getInfo();
    }

    @GetMapping("/getIndex")
    public Object getIndex(String tenant){
        LoginContext.setLoginUser(LoginContext.LoginUser.builder().ssoName("lyj").tenant(tenant).build());
        return null;
    }
    @GetMapping("/getInfo")
    public Object getIndexPlus(String tenant){
        LoginContext.setLoginUser(LoginContext.LoginUser.builder().ssoName("lyj").tenant(tenant).build());
        return context.getInfo();
    }



}
