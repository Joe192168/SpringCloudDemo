package com.joe.springcloud.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xqh
 * @Title: Producer8001客户端
 * @Description:
 * @date 2022/9/2117:35
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientProducer8001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProducer8001Application.class,args);
    }

}
