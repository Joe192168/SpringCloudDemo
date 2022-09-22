package com.joe.springcloud.consul.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqh
 * @Title: Consul9005客户端
 * @Description:
 * @date 2022/9/2213:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulClientConsumer9005Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulClientConsumer9005Application.class,args);
    }

}
