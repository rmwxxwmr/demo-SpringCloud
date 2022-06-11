package me.chenjd.demo.cloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Setter
@Getter
@TableName("account_tbl")
public class Account {

    private Integer userId;

    private Integer money;

}
