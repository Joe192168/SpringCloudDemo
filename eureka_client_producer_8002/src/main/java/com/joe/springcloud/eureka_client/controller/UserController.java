package com.joe.springcloud.eureka_client.controller;

import com.joe.springcloud.common.tools.Result;
import com.joe.springcloud.eureka_client.entity.User;
import com.joe.springcloud.eureka_client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * user 前端控制器
 * </p>
 *
 * @author joe
 * @since 2022-09-21
 */
@RestController
@RequestMapping("/producer/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${eureka.instance.hostname}")
    private String hostname;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Result discovery() {
        // 获取服务名列表
        List<String> servicesList = discoveryClient.getServices();

        // 根据服务名 获取 每个服务名下的 各个服务的信息
        Map<String, List<ServiceInstance>> map = new HashMap<>();
        servicesList.stream().forEach(service -> {
            map.put(service, discoveryClient.getInstances(service));
        });

        return Result.ok(true, 200, "discovery services success").data("services", map);
    }

    @GetMapping("/get/{id}")
    public Result getUser(@PathVariable Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            return Result.error(false, 404, "data not found").data("ip", (hostname + ":" + port));
        }
        return Result.ok(true, 200, "query data success").data("user", user).data("ip", (hostname + ":" + port));
    }

    @PostMapping("/create")
    public Result createUser(@RequestBody User user) {
        boolean result = userService.save(user);
        if (!result) {
            return Result.error(false, 404, "create data error").data("ip", (hostname + ":" + port));
        }
        return Result.ok(true, 200, "create data success").data("ip", (hostname + ":" + port));
    }
}

