package me.chenjd.demo.cloud.alibaba.service;

import io.seata.spring.annotation.GlobalTransactional;
import me.chenjd.demo.cloud.alibaba.entity.Order;
import me.chenjd.demo.cloud.alibaba.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Service
public class OrderService {

    private final OrderMapper orderMapper;

    private final RestTemplate restTemplate;

    public OrderService(OrderMapper orderMapper, RestTemplate restTemplate) {
        this.orderMapper = orderMapper;
        this.restTemplate = restTemplate;
    }

    /**
     * 下单：创建订单、减库存，件账户金额
     */
    @GlobalTransactional
    @Transactional
    public void buy(Integer userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(100));
        restTemplate.getForEntity("http://localhost:9202/stock/buy?commodityCode=" + commodityCode + "&count=" + count,String.class);
        restTemplate.getForEntity("http://localhost:9203/account/buy?userId=" + userId + "&money=" + orderMoney,String.class);
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);
        orderMapper.insert(order);
    }

}
