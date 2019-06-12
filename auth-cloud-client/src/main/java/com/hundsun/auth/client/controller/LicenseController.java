package com.hundsun.auth.client.controller;

import com.hundsun.auth.base.dto.ResultDto;
import com.hundsun.auth.dto.Product;
import com.hundsun.auth.service.LicenseService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 许可证
 *
 * Created by jiayq24996 on 2019-06-12
 */
@RestController(value = "license")
public class LicenseController {

    @CloudReference
    private LicenseService licenseService;
    /**
     * 许可证上传
     *
     * @param product
     * @return
     */
    @GetMapping(value = "/license/save")
    public ResultDto save(Product product){
        return licenseService.save(product);
    }


}
