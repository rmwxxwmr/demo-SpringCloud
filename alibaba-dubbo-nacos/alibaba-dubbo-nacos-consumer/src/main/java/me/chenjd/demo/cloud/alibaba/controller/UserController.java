package me.chenjd.demo.cloud.alibaba.controller;

import me.chenjd.demo.cloud.alibaba.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2022/6/11 20:24
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping
    public String get(){
        return userService.getUser();
    }


}
