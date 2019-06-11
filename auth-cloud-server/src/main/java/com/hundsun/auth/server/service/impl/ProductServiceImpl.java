package com.hundsun.auth.server.service.impl;

import com.hundsun.auth.dto.Product;
import com.hundsun.auth.server.common.base.BaseServiceImpl;
import com.hundsun.auth.server.dao.ProductDao;
import com.hundsun.auth.service.ProductService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@CloudComponent
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    protected Mapper<Product> getMapper() {
        return this.productDao;
    }
}
