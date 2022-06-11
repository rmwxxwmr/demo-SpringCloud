package me.chenjd.demo.cloud.alibaba.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @GetMapping("/reduce")
    Boolean reduce(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);
}
