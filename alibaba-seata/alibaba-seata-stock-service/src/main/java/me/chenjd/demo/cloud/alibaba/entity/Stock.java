package me.chenjd.demo.cloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Setter
@Getter
@TableName("stock_tbl")
public class Stock {

    @TableId
    private String commodityCode;

    private Integer count;

}
