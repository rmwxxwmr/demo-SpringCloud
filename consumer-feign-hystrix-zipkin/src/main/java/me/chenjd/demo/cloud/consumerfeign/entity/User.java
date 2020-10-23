package me.chenjd.demo.cloud.consumerfeign.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chenjd
 * @date 2020/10/10 14:17
 */
@Getter
@Setter
public class User {

    private String userName;

    private Integer userId;

    private String port;

    private String errorMsg;

}
