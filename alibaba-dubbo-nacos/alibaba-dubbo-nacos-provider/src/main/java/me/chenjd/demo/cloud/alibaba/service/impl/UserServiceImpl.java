package me.chenjd.demo.cloud.alibaba.service.impl;

import me.chenjd.demo.cloud.alibaba.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author chenjd
 * @date 2022/6/11 20:29
 */
@Service
public class UserServiceImpl implements UserService {

    public String getUser() {
        return "get user success";
    }
}
