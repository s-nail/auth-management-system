package com.hundsun.auth.client.controller;

import com.hundsun.auth.dto.Product;
import com.hundsun.auth.service.ProductService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-11
 */
@RestController
public class ProductController {

    @CloudReference
    private ProductService productService;

    @GetMapping(value = "getProduct")
    public Product getProduct() {
        return productService.getById(1);
    }

}
