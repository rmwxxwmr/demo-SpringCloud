package me.chenjd.demo.cloud.consumerfeign.controller;

import me.chenjd.demo.cloud.consumerfeign.entity.User;
import me.chenjd.demo.cloud.consumerfeign.feign.DemoFeignClients;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenjd
 * @date 2020/10/10 13:47
 */
@RestController
@RequestMapping
public class FeignController {

    private final DemoFeignClients demoFeignClients;

    public FeignController(DemoFeignClients demoFeignClients) {
        this.demoFeignClients = demoFeignClients;
    }

    @GetMapping("{userId}")
    @ResponseBody
    public User test(@PathVariable Integer userId, String userName){
        return demoFeignClients.test(userId, userName);
    }

}
