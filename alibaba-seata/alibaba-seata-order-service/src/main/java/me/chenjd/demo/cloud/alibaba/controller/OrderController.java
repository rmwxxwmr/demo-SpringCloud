package me.chenjd.demo.cloud.alibaba.controller;

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
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 下单：插入订单表、扣减库存,扣账户金额
     */
    @GetMapping("buy")
    public String buy(Integer userId,String commodityCode, Integer count) {
        orderService.buy(userId, commodityCode, count);
        return "success";
    }

}
