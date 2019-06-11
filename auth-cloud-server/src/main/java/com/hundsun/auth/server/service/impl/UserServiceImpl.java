package com.hundsun.auth.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hundsun.auth.dto.User;
import com.hundsun.auth.server.dao.UserDao;
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

    public List<User> getUser(int pageNo,int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userDao.selectAll();
        PageInfo<User> page = new PageInfo<User>(list);
        System.out.println("list============"+page.getList());
        return list;
    }
}
