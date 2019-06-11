package com.hundsun.auth.client.controller;

import com.hundsun.auth.dto.User;
import com.hundsun.auth.service.UserService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-10
 */
@RestController
public class UserController {
    @CloudReference
    private UserService userService;

    @GetMapping(value = "getUser")
    public List<User> getUser(int userId) {
        return userService.getUser(userId);
    }
}
