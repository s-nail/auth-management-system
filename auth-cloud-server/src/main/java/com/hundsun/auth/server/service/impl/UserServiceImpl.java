package com.hundsun.auth.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hundsun.auth.dto.User;
import com.hundsun.auth.server.common.base.BaseServiceImpl;
import com.hundsun.auth.server.dao.UserDao;
import com.hundsun.auth.service.UserService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@CloudComponent
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    protected Mapper<User> getMapper() {
        return this.userDao;
    }

    public List<User> getUser(int pageNo,int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userDao.selectAll();
        PageInfo<User> page = new PageInfo<User>(list);
        System.out.println("list============"+page.getList());
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    public int insert(User user) {
        user.setId(3);
        user.setUsername("Hi");
        user.setPassword("1222");
        userDao.insertUser(user);

        //模拟主键冲突
        User user1 =new User();
        user1.setId(1);
        user1.setUsername("Hi");
        user1.setPassword("1222");
        userDao.insertUser(user1);
        return 0;
    }


}
