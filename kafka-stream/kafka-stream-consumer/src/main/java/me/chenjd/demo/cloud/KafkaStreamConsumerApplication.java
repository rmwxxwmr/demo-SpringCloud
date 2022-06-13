package me.chenjd.demo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenjd
 * @date 2022/6/13 20:32
 */
@SpringBootApplication
public class KafkaStreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamConsumerApplication.class,args);
    }

}