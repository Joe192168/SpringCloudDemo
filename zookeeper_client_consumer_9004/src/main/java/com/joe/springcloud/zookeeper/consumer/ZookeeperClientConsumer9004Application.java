package com.joe.springcloud.zookeeper.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqh
 * @Title: Zookeeper9003客户端
 * @Description:
 * @date 2022/9/229:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperClientConsumer9004Application {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperClientConsumer9004Application.class,args);
    }

}
