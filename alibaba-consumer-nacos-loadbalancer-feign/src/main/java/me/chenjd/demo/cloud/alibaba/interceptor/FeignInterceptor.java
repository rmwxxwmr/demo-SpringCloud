package me.chenjd.demo.cloud.alibaba.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenjd
 * @date 2022/6/9 23:05
 */
@Slf4j
public class FeignInterceptor implements RequestInterceptor {

    public void apply(RequestTemplate requestTemplate) {
        log.info("feign interceptor.....");
    }
}
