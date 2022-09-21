package com.joe.springcloud.eureka_client_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xqh
 * @Title: EurekaConsumer客户端
 * @Description:
 * @date 2022/9/2117:44
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientConsumer9002Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumer9002Application.class,args);
    }

}
