package com.hundsun.auth.service.impl;

import com.hundsun.auth.dao.UserDao;
import com.hundsun.auth.dto.User;
import com.hundsun.auth.service.UserService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@CloudComponent
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUser(int userId) {
        List<User> list = userDao.listUser();
        return list;
    }
}
