package me.chenjd.demo.cloud.alibaba.service;

import me.chenjd.demo.cloud.alibaba.entity.Stock;
import me.chenjd.demo.cloud.alibaba.mapper.StockMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Service
public class StockService {

    private final StockMapper stockMapper;

    public StockService(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    /**
     * 减库存
     */
    @Transactional
    public void buy(String commodityCode, int count) {
        Stock stock = stockMapper.selectById(commodityCode);
        int finalCount = stock.getCount() - count;
        if(finalCount>=0){
            stock.setCount(finalCount);
            stockMapper.updateById(stock);
        }
        else {
            throw new RuntimeException("库存不足!");
        }
    }
}
