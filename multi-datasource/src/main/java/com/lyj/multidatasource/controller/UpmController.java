package com.lyj.multidatasource.controller;

import com.lyj.multidatasource.config.LoginContext;
import com.lyj.multidatasource.config.UPMContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UpmController
 * @Description UpmController
 * @Author liyongjie
 * @Date 2021/5/17 3:40 下午
 */
@RestController
@RequestMapping("/upm")
public class UpmController {
    @Autowired
    private UPMContext upmContext;

    @GetMapping("/get")
    public Object get(String tenant){

        LoginContext.setLoginUser(LoginContext.LoginUser.builder().ssoName("lyj").tenant(tenant).build());
        return upmContext.getRole(tenant);
    }
}
