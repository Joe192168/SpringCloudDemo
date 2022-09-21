package com.joe.springcloud.eureka_client_consumer.controller;

import com.joe.springcloud.common.tools.Result;
import com.joe.springcloud.eureka_client_consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/user")
public class ConsumerController {

    // 注意，此处 url 写死的，仅用于演示，实际项目中不能这么干。
    //public static final String PRODUCER_URL = "http://localhost:8000/producer/";
    public static final String PRODUCER_URL = "http://EUREKA-CLIENT-PRODUCER-8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public Result getUser(@PathVariable Integer id) {
        return restTemplate.getForObject(PRODUCER_URL + "/producer/user/get/" + id, Result.class);
    }

    @PostMapping("/create")
    public Result createUser(@RequestBody User user) {
        return restTemplate.postForObject(PRODUCER_URL + "/producer/user/create", user, Result.class);
    }
}
