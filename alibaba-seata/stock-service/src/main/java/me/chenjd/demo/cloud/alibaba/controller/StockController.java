package me.chenjd.demo.cloud.alibaba.controller;

import me.chenjd.demo.cloud.alibaba.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@RestController
@RequestMapping("stock")
public class StockController {

    @Resource
    private StockService stockService;

    /**
     * 减库存
     */
    @RequestMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        stockService.deduct(commodityCode, count);
        return true;
    }

}
