package com.hundsun.auth.server.dao;

import com.hundsun.auth.dto.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@Mapper
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User> {

}
