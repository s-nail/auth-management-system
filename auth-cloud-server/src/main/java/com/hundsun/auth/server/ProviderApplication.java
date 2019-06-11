package com.hundsun.auth.server;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@CloudApplication
@EnableCloudDataSource
public class ProviderApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(ProviderApplication.class, args);
    }
}
