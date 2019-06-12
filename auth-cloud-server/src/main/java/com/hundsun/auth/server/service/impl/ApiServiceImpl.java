package com.hundsun.auth.server.service.impl;

import com.hundsun.auth.server.dao.ApiDao;
import com.hundsun.auth.service.ApiService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@CloudComponent
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiDao aipDao;

}
