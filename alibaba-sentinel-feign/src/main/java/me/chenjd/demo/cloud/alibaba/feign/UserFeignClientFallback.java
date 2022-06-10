package me.chenjd.demo.cloud.alibaba.feign;

import lombok.extern.slf4j.Slf4j;
import me.chenjd.demo.cloud.alibaba.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenjd
 * @date 2022/6/10 15:31
 */
@Component
@Slf4j
public class UserFeignClientFallback implements UserFeignClient {

    public List<User> getList() {
        log.error("user abnormal...degrade");
        return null;
    }

    public User get(Integer userId) {
        log.error("user abnormal...degrade,userId:"+userId);
        return null;
    }
}
