package com.hundsun.auth.server.service.impl;

import com.hundsun.auth.dto.Module;
import com.hundsun.auth.server.common.base.BaseServiceImpl;
import com.hundsun.auth.server.dao.ModuleDao;
import com.hundsun.auth.service.ModuleService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@CloudComponent
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    protected Mapper<Module> getMapper() {
        return this.moduleDao;
    }
}
