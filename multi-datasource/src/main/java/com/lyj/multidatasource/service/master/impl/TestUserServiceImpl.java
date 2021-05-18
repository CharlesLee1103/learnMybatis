package com.lyj.multidatasource.service.master.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyj.multidatasource.entity.master.TestUser;
import com.lyj.multidatasource.mapper.master.MasterTestUserMapper;
import com.lyj.multidatasource.service.master.ITestUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlesliyongjie
 * @since 2021-05-12
 */
@Service("masterService")
public class TestUserServiceImpl extends ServiceImpl<MasterTestUserMapper, TestUser> implements ITestUserService {

}
