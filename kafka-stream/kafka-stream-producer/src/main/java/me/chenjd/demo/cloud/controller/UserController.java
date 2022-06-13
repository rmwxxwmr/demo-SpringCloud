package me.chenjd.demo.cloud.controller;

import me.chenjd.demo.cloud.config.ProducerConfig;
import me.chenjd.demo.cloud.entity.User;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2022/6/13 20:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final StreamBridge streamBridge;

    private final ProducerConfig producerConfig;

    public UserController(StreamBridge streamBridge, ProducerConfig producerConfig) {
        this.streamBridge = streamBridge;
        this.producerConfig = producerConfig;
    }

    @GetMapping("/log")
    public boolean log(){
        User user = new User();
        user.setUserId(2);
        user.setUserName("user test log 1");
        user.setAge(10);
        producerConfig.log(user);
        return true;
    }

    @GetMapping("/addAge")
    public boolean addAge(){
        User user = new User();
        user.setUserId(1);
        user.setUserName("user test add age 1");
        user.setAge(10);
        return streamBridge.send("addAge",user);
    }

}
