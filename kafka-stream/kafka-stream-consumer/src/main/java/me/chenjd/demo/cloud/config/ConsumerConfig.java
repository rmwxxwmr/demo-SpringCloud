package me.chenjd.demo.cloud.config;

import lombok.extern.slf4j.Slf4j;
import me.chenjd.demo.cloud.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author chenjd
 * @date 2022/6/13 21:05
 */
@Configuration
@Slf4j
public class ConsumerConfig {

    /**
     * 对应yml中配置的logC-in-0通道，即topic log。
     **/
    @Bean
    public Consumer<User> logC(){
        return user -> log.info("receive log user:{}",user);
    }

    /**
     * 对应yml中配置的addAgeC-in-0通道，即topic addAge。
     * 消费topic addAge中的消息
     **/
    @Bean
    public Consumer<User> addAgeC(){
        return user->{
            user.setAge(user.getAge()+10);
            log.info("receive add age user:{}",user);
        };
    }

}
