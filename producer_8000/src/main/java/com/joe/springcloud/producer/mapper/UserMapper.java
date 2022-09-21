package com.joe.springcloud.producer.mapper;

import com.joe.springcloud.producer.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
