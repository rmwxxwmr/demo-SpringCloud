package me.chenjd.demo.cloud.alibaba;

import me.chenjd.demo.cloud.alibaba.message.DemoSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author chenjd
 * @date 2022/6/12 10:08
 */
@SpringBootApplication
@EnableBinding(DemoSource.class)
public class RocketmqStreamProviderApplication {

    public static void main(String[] args){
        SpringApplication.run(RocketmqStreamProviderApplication.class,args);
    }

}
