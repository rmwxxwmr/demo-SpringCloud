package me.chenjd.demo.cloud.alibaba.controller;

import me.chenjd.demo.cloud.alibaba.entity.User;
import me.chenjd.dplatform.commons.utils.ReflectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author chenjd
 * @date 2022/6/9 13:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${provider-nacos-url}")
    private String providerNacosUrl;

    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public List<User> getList(){
        return ReflectUtils.parse(restTemplate.getForObject(providerNacosUrl+"/user",List.class));
    }

    @GetMapping("{userId}")
    public User get(@PathVariable("userId") Integer userId){
        return restTemplate.getForObject(providerNacosUrl+"/user/"+userId,User.class);
    }

}
