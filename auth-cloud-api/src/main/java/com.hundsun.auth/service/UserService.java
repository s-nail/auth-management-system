package com.hundsun.auth.service;


import com.hundsun.auth.dto.User;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@CloudService
public interface UserService {

    @CloudFunction
    List<User> getUser(int pageNo,int pageSize);
}
