package com.joe.springcloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqh
 * @Title: Nacos7100客户端
 * @Description:
 * @date 2022/9/2214:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClient7102Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosClient7102Application.class,args);
    }

}
