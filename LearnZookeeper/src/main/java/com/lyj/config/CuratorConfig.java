package com.lyj.config;

import com.lyj.pojo.WrapperZK;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CuratorConfig {

    @Autowired
    WrapperZK wrapperZK;

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.newClient(
                wrapperZK.getConnectString(), // 127.0.0.1:2181
                wrapperZK.getSessionTimeoutMs(), // 60000
                wrapperZK.getConnectionTimeoutMs(), // 5000
                new RetryNTimes(wrapperZK.getRetryCount(), wrapperZK.getElapsedTimeMs())
        );
    }
}
