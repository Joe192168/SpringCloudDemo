package com.joe.springcloud.nacos.consumer.controller;

import com.joe.springcloud.nacos.consumer.service.ConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/consumer")
@RestController
public class TestController {

    @Autowired
    private ConsumerFeign consumerFeign;

    @RequestMapping("/info")
    public String getInfo() {
        return consumerFeign.getInfo();
    }
}