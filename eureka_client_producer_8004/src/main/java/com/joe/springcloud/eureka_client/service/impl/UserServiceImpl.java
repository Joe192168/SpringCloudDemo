package com.joe.springcloud.eureka_client.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joe.springcloud.eureka_client.entity.User;
import com.joe.springcloud.eureka_client.mapper.UserMapper;
import com.joe.springcloud.eureka_client.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user 服务实现类
 * </p>
 *
 * @author joe
 * @since 2022-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
