package com.hundsun.auth.client;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@CloudApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(ConsumerApplication.class, args);
    }
}
