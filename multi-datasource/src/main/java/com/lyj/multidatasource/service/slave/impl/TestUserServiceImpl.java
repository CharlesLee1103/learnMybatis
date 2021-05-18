package com.lyj.multidatasource.service.slave.impl;

import com.lyj.multidatasource.entity.slave.TestUser;
import com.lyj.multidatasource.mapper.slave.SlaveTestUserMapper;
import com.lyj.multidatasource.service.slave.ITestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author charlesliyongjie
 * @since 2021-05-12
 */
@Service("slaveService")
public class TestUserServiceImpl extends ServiceImpl<SlaveTestUserMapper, TestUser> implements ITestUserService {

}
