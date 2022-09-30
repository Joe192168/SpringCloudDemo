package com.joe.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xqh
 * @Title: 网关7200
 * @Description:
 * @date 2022/9/2812:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWay7200Application {

    public static void main(String[] args) {
        SpringApplication.run(GateWay7200Application.class,args);
    }

}
