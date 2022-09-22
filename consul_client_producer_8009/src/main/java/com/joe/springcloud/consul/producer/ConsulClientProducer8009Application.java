package com.joe.springcloud.consul.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqh
 * @Title: Consul8009客户端
 * @Description:
 * @date 2022/9/2213:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulClientProducer8009Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulClientProducer8009Application.class,args);
    }

}
