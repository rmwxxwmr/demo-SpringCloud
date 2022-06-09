package me.chenjd.demo.cloud.alibaba.config;

import feign.RequestInterceptor;
import me.chenjd.demo.cloud.alibaba.interceptor.FeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenjd
 * @date 2022/6/9 23:05
 */
@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor getFeignInterceptor(){
        return new FeignInterceptor();
    }

}
