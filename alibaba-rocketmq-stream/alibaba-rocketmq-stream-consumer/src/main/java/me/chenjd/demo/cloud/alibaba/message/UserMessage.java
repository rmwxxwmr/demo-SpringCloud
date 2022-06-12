package me.chenjd.demo.cloud.alibaba.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chenjd
 * @date 2022/6/12 10:34
 */
@Getter
@Setter
@ToString
public class UserMessage {

    private int userId;

    private String userName;

    private String comment;

}
