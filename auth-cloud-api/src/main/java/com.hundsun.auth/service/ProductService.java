package com.hundsun.auth.service;

import com.hundsun.auth.base.service.BaseService;
import com.hundsun.auth.dto.Product;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@CloudService
public interface ProductService extends BaseService<Product> {

}
