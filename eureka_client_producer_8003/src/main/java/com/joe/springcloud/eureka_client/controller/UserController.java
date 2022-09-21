package com.joe.springcloud.eureka_client.controller;

import com.joe.springcloud.common.tools.Result;
import com.joe.springcloud.eureka_client.entity.User;
import com.joe.springcloud.eureka_client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

