package com.hundsun.auth.server.dao;

import com.hundsun.auth.dto.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@org.apache.ibatis.annotations.Mapper
public interface UserDao extends Mapper<User> {

    int insertUser(User user);

}
