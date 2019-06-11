package com.hundsun.auth.server.service.impl;

import com.hundsun.auth.dto.Api;
import com.hundsun.auth.server.common.base.BaseServiceImpl;
import com.hundsun.auth.server.dao.AipDao;
import com.hundsun.auth.service.ApiService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@CloudComponent
public class ApiServiceImpl extends BaseServiceImpl<Api> implements ApiService {

    @Autowired
    private AipDao aipDao;

    @Override
    protected Mapper getMapper() {
        return this.aipDao;
    }
}
