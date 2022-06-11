package me.chenjd.demo.cloud.alibaba.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chenjd
 * @date 2022/6/11 16:27
 */
@RestControllerAdvice
@Slf4j
public class GlobalAdvice {

    @ExceptionHandler(Throwable.class)
    public String errorHandler(Throwable t){
        log.error("service error...cause:",t);
        return "service error...cause:"+t.getMessage();
    }

}
