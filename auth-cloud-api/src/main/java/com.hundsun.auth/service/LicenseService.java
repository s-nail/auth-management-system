package com.hundsun.auth.service;

import com.hundsun.auth.base.dto.ResultDto;
import com.hundsun.auth.dto.Product;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * Created by jiayq24996 on 2019-06-12
 */
@CloudService
public interface LicenseService {

    /**
     * 保存许可证信息，生成license.lic文件，并把license.lic上传到许可中心
     *
     * @param product
     * @return
     */
    ResultDto save(Product product);

}
