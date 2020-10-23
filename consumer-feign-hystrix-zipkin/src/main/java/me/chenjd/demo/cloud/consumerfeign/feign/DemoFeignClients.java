package me.chenjd.demo.cloud.consumerfeign.feign;

import me.chenjd.demo.cloud.consumerfeign.entity.User;
import me.chenjd.demo.cloud.consumerfeign.hystrix.DemoFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjd
 * @date 2020/10/10 13:53
 */
@FeignClient(value = "provider-sleuth-zipkin-cluster",fallbackFactory = DemoFallbackFactory.class)
public interface DemoFeignClients {

    @GetMapping("/test/feign/{userId}")
    @ResponseBody
    User test(@PathVariable Integer userId, @RequestParam("userName") String userName);

}
