package me.chenjd.demo.cloud.alibaba.service;

import io.seata.spring.annotation.GlobalTransactional;
import me.chenjd.demo.cloud.alibaba.feign.AccountFeignClient;
import me.chenjd.demo.cloud.alibaba.model.Order;
import me.chenjd.demo.cloud.alibaba.repository.OrderDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Service
public class OrderService {

    @Resource
    private AccountFeignClient accountFeignClient;
/*    @Resource
    private StockFeignClient stockFeignClient;*/
    @Resource
    private OrderDAO orderDAO;

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 下单：创建订单、减库存，涉及到两个服务
     */
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order().setUserId(userId).setCommodityCode(commodityCode).setCount(count).setMoney(
            orderMoney);
        orderDAO.insert(order);
//        stockFeignClient.deduct(commodityCode, count);
        restTemplate.getForEntity("http://localhost:9202/stock/deduct?commodityCode=" + commodityCode + "&count=" + count,Boolean.class);

    }

    @Transactional(rollbackFor = Exception.class)
    public void create(String userId, String commodityCode, Integer count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order().setUserId(userId).setCommodityCode(commodityCode).setCount(count).setMoney(
            orderMoney);
        orderDAO.insert(order);
        accountFeignClient.reduce(userId, orderMoney);
    }

}
