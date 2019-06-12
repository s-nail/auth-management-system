package com.hundsun.auth.server.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.hundsun.auth.base.dto.ResultDto;
import com.hundsun.auth.dto.Module;
import com.hundsun.auth.dto.Product;
import com.hundsun.auth.entity.TSysProduct;
import com.hundsun.auth.server.dao.ApiDao;
import com.hundsun.auth.server.dao.ModuleDao;
import com.hundsun.auth.server.dao.ProductDao;
import com.hundsun.auth.service.LicenseService;
import com.hundsun.auth.util.XStreamUtil;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-12
 */
@CloudComponent
public class LicenseServiceImpl implements LicenseService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ModuleDao moduleDao;
    @Autowired
    private ApiDao apiDao;

    public ResultDto save(Product product) {
        //测试使用
        product.setLicenceNo("1111");
        product.setLicenceType("1");
        product.setBeginDate("20190611");
        product.setExpireDate("20210611");
        List<Module> list = new ArrayList<Module>();
        Module module = new Module();
        module.setModuleName("用户管理");
        module.setModuleNo("000");
        module.setBeginDate("20190611");
        module.setBeginDate("20210611");
        list.add(module);
        product.setModules(list);

        TSysProduct tSysProduct = new TSysProduct();
        List<Module> list1 = new ArrayList<Module>();
        List<Module> list2 = new LinkedList<Module>();
        BeanUtils.copyProperties(product, tSysProduct);
        BeanUtils.copyProperties(product.getModules(), list1);
        BeanUtils.copyProperties(product.getModules(), list2);

        String path = this.getClass().getResource("/license/license.lic").getPath();

        /*String contentStr = FileUtil.readUtf8String(path);
        //xml转对象
        Class[] types = {Product.class, Api.class, ExtendField.class, Module.class};
        Product product = XStreamUtil.xmlToBean(contentStr, types);*/

        //product对象转xml
        String initStr = XStreamUtil.beanToXml(product);
        // 覆盖式写入源文件
        //FileUtil.writeString(initStr, path, "UTF-8");
        String base64Str = Base64.encodeBase64String(FileUtil.readBytes(path));
        String base64 = Base64.encodeBase64String(initStr.getBytes());
        System.out.println(base64Str);
        System.out.println(base64);

        if (StrUtil.equals(base64Str, base64)) {
            System.out.println("=========================");
        }
        return null;
    }
}
