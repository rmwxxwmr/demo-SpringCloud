package me.chenjd.demo.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2022/6/10 9:00
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Value("${user.classroom}")
    private String classroom;

    @GetMapping("/classroom")
    public String getClassroom(){
        return classroom;
    }

}
