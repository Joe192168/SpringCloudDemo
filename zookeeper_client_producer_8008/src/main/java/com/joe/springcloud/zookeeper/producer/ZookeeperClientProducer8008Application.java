package com.joe.springcloud.zookeeper.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqh
 * @Title: Zookeeper8005客户端
 * @Description:
 * @date 2022/9/229:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperClientProducer8008Application {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperClientProducer8008Application.class,args);
    }

}
