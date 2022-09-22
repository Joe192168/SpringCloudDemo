package com.joe.springcloud.zookeeper.producer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joe.springcloud.zookeeper.producer.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * user Mapper 接口
 * </p>
 *
 * @author joe
 * @since 2022-09-21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
