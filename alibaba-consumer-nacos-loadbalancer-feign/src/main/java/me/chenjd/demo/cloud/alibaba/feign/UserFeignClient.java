package me.chenjd.demo.cloud.alibaba.feign;

import me.chenjd.demo.cloud.alibaba.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chenjd
 * @date 2022/6/9 22:26
 */
@FeignClient(name = "provider-nacos",path = "/provider-nacos/user")
public interface UserFeignClient {

    @GetMapping
    @ResponseBody
    List<User> getList();

    @GetMapping("{userId}")
    @ResponseBody
    User get(@PathVariable("userId")Integer userId);

}
