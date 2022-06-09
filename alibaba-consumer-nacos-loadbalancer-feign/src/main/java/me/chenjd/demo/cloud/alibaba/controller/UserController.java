package me.chenjd.demo.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import me.chenjd.demo.cloud.alibaba.entity.User;
import me.chenjd.demo.cloud.alibaba.feign.UserFeignClient;
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
@Slf4j
public class UserController {

/*    @Value("${provider-nacos-url}")
    private String providerNacosUrl;*/

    private final RestTemplate restTemplate;

    private final UserFeignClient userFeignClient;


    public UserController(RestTemplate restTemplate, UserFeignClient userFeignClient) {
        this.restTemplate = restTemplate;
        this.userFeignClient = userFeignClient;
    }


    @GetMapping
    public List<User> getList(){
//        return ReflectUtils.parse(restTemplate.getForObject(providerNacosUrl+"/user",List.class));
        return userFeignClient.getList();
    }

    @GetMapping("{userId}")
    public User get(@PathVariable("userId") Integer userId){
//        return restTemplate.getForObject(providerNacosUrl+"/user/"+userId,User.class);
        return userFeignClient.get(userId);
    }

}
