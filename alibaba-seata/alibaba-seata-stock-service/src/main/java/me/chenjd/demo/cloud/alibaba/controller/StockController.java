package me.chenjd.demo.cloud.alibaba.controller;

import me.chenjd.demo.cloud.alibaba.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@RestController
@RequestMapping("stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * 减库存
     */
    @GetMapping(path = "/buy")
    public String buy(String commodityCode, Integer count) {
        stockService.buy(commodityCode, count);
        return "success";
    }

}
