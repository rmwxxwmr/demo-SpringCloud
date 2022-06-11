package me.chenjd.demo.cloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Setter
@Getter
@TableName("order_tbl")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String commodityCode;

    private Integer count;

    private BigDecimal money;

}
