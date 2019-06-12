package com.hundsun.auth.server.service.impl;

import com.hundsun.auth.dto.Module;
import com.hundsun.auth.server.dao.ModuleDao;
import com.hundsun.auth.service.ModuleService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@CloudComponent
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;


}
