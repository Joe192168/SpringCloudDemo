package com.joe.springcloud.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xqh
 * @Title: Eureka7000服务
 * @Description:
 * @date 2022/9/2117:28
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003Application.class,args);
    }

}
