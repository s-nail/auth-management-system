package com.hundsun.auth.server.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.hundsun.auth.base.dto.ResultDto;
import com.hundsun.auth.base.dto.ResultDtoFactory;
import com.hundsun.auth.dto.Api;
import com.hundsun.auth.dto.Module;
import com.hundsun.auth.dto.Product;
import com.hundsun.auth.entity.TSysApi;
import com.hundsun.auth.entity.TSysProduct;
import com.hundsun.auth.entity.TSysProductModule;
import com.hundsun.auth.server.dao.ApiDao;
import com.hundsun.auth.server.dao.ModuleDao;
import com.hundsun.auth.server.dao.ProductDao;
import com.hundsun.auth.service.LicenseService;
import com.hundsun.auth.util.HSBlowfish;
import com.hundsun.auth.util.XStreamUtil;
import com.hundsun.jres.permit.api.service.LicenceService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @CloudReference
    private LicenceService licenceService;

    @Transactional(rollbackFor = Exception.class)
    public ResultDto save(Product product) {

        //测试使用
        /*product.setLicenceNo("12868");
        product.setLicenceType("1");
        product.setBeginDate("20190601");
        product.setExpireDate("20210701");
        product.setUserInfo("Shaw");
        product.setProductInfo("demo-player");
        product.setFlowControl("10");
        List<Module> list = new ArrayList<Module>();
        Module module1 = new Module();
        module1.setModuleName("运动员管理");
        module1.setModuleNo("001");
        module1.setBeginDate("20190601");
        module1.setExpireDate("20210701");
        module1.setMaxConnections(8);
        module1.setFlowControl("15");
        list.add(module1);
        product.setModules(list);

        Api api1 = new Api();
        List<Api> apiList = new ArrayList<Api>();
        api1.setApiName("save");
        api1.setFunctionId("808588");
        api1.setBeginDate("20190601");
        api1.setExpireDate("20190701");
        api1.setFlowControl("15");
        apiList.add(api1);
        module1.setApiSet(apiList);*/

        //TODO 判空处理???
        //1.保存到本地数据库中
        TSysProduct tSysProduct = new TSysProduct();
        BeanUtils.copyProperties(product, tSysProduct);
        tSysProduct.setProductId(IdUtil.simpleUUID());
        tSysProduct.setCreateDate(DateUtil.now());
        tSysProduct.setCreator("admin");
        productDao.insertSelective(tSysProduct);
        if (CollectionUtils.isNotEmpty(product.getModules())) {
            for (Module module : product.getModules()) {
                TSysProductModule tSysProductModule = new TSysProductModule();
                BeanUtils.copyProperties(module, tSysProductModule);
                tSysProductModule.setModuleId(IdUtil.simpleUUID());
                tSysProductModule.setProductId(tSysProduct.getProductId());
                moduleDao.insertSelective(tSysProductModule);
                if (CollectionUtils.isNotEmpty(module.getApiSet())) {
                    for (Api api : module.getApiSet()) {
                        TSysApi tSysApi = new TSysApi();
                        BeanUtils.copyProperties(api, tSysApi);
                        tSysApi.setApiId(IdUtil.simpleUUID());
                        tSysApi.setModuleId(tSysProductModule.getModuleId());
                        apiDao.insertSelective(tSysApi);
                    }
                }
            }

        }
        //2.解析product对象，生成xml，再加密发送到许可中心
        //product对象转xml
        String initStr = XStreamUtil.beanToXml(product);
        byte[] encode;
        try {
            encode = HSBlowfish.encodeWithBase64(initStr.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDtoFactory.toNack("HSBlowfish加密失败");
        }
        if (licenceService.importLicence(encode)) {
            return ResultDtoFactory.toAck("上传成功");
        } else {
            return ResultDtoFactory.toNack("上传失败");
        }
    }

}
