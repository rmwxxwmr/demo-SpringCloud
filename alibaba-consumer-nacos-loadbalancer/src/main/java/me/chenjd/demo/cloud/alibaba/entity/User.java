package me.chenjd.demo.cloud.alibaba.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author chenjd
 * @date 2022/6/9 13:58
 */
@Getter
@Setter
@Accessors(chain = true)
public class User {

    private String userName;

    private Integer userId;

    private String sex;

    private Integer age;

}
