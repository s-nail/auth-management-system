package com.hundsun.auth.server.dao;

import com.hundsun.auth.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@Mapper
public interface UserDao {
    int insert(User record);

    int insertSelective(User record);

    List<User> listUser();
}
