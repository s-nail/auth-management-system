package com.hundsun.auth.server.service.impl;

import com.hundsun.auth.entity.TSysProduct;
import com.hundsun.auth.server.dao.ProductDao;
import com.hundsun.auth.service.ProductService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@CloudComponent
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public TSysProduct getById(String id) {
        TSysProduct product =new TSysProduct();
        product.setProductId(id);
        return productDao.selectByPrimaryKey(product);
    }
}
