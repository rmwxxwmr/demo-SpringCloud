package me.chenjd.demo.cloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Data
@Accessors(chain = true)
@TableName("stock_tbl")
public class Stock {

    private Long id;
    private String commodityCode;
    private Long count;

}
