package me.chenjd.demo.cloud.config;

import me.chenjd.demo.cloud.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

/**
 * @author chenjd
 * @date 2022/6/13 20:48
 */
@Configuration
public class ProducerConfig {

    private final BlockingQueue<User> queue=new LinkedBlockingQueue<>();

    /**
     * 对应yml中配置的logP-out-0通道，即topic log
     **/
    @Bean
    public Supplier<User> logP(){
        return queue::poll;
    }

    /**
     * 调用本方法向log topic发送消息
     **/
    public void log(User user){
        boolean offer = queue.offer(user);
    }

}
