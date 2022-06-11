package me.chenjd.demo.cloud.alibaba.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@FeignClient(name = "seata-stock-service")
public interface StockFeignClient {

    @GetMapping("stock/deduct")
    Boolean deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
