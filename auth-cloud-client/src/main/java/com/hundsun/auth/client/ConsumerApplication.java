package com.hundsun.auth.client;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.monitor.DbMonitorAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@CloudApplication(exclude = {DataSourceAutoConfiguration.class, DbMonitorAutoConfiguration.class})
public class ConsumerApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(ConsumerApplication.class, args);
    }
}
