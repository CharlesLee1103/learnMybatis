package com.lyj.multidatasource.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyj.multidatasource.entity.master.TestUser;
import com.lyj.multidatasource.mapper.master.MasterTestUserMapper;
import com.lyj.multidatasource.mapper.slave.SlaveTestUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlesliyongjie
 * @since 2021-05-12
 */
@Slf4j
@RestController
@RequestMapping("/multidatasource/test-user")
public class TestUserController {
    @Autowired
    private MasterTestUserMapper masterTestUserMapper;
    @Autowired
    private SlaveTestUserMapper slaveTestUserMapper;

    @GetMapping("/listall")
    public Object listAll(){
        QueryWrapper<TestUser> queryWrapper = new QueryWrapper<>();
        List<TestUser> masterUserList = masterTestUserMapper.selectList(queryWrapper.isNotNull("name"));
        QueryWrapper<com.lyj.multidatasource.entity.slave.TestUser> slaveQueryWrapper = new QueryWrapper<>();
        List<com.lyj.multidatasource.entity.slave.TestUser> slaveUserList = slaveTestUserMapper.selectList(slaveQueryWrapper.like("name","test"));
        Map<String, Object> result = new HashMap<>();
        result.put("master", masterUserList);
        result.put("slave", slaveUserList);
        log.info("this is result={}",result);
        return result;
    }
}
