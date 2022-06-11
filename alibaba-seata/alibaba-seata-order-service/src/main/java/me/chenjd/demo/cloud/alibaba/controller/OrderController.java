package me.chenjd.demo.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import me.chenjd.demo.cloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 下单：插入订单表、扣减库存,扣账户金额
     * <a href="http://localhost:9201/order/buy?userId=1&commodityCode=product-1&count=1">demo</a>
     */
    @GetMapping("buy")
    public String buy(Integer userId,String commodityCode, Integer count) {
        log.info("request order service...userId:{},commodityCode:{},count:{}",userId,commodityCode,count);
        orderService.buy(userId, commodityCode, count);
        return "success";
    }

}
