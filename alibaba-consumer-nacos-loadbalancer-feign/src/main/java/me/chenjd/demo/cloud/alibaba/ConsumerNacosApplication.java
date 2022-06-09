package me.chenjd.demo.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerNacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerNacosApplication.class, args);
	}

}
