package com.joe.springcloud.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xqh
 * @Title: NacoseConsumer客户端
 * @Description:
 * @date 2022/9/2215:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientConsumerApplication.class,args);
    }
}
