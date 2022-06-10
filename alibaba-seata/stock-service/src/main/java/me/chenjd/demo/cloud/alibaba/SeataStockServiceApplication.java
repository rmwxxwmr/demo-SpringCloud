
package me.chenjd.demo.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.work"})
public class SeataStockServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStockServiceApplication.class, args);
    }

}
