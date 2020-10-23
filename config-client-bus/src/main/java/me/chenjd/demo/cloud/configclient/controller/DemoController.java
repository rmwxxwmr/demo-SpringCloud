package me.chenjd.demo.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2020/10/12 14:54
 */
@RestController
@RequestMapping
@RefreshScope
public class DemoController {

    @Value("${foo}")
    private String testValue;

    @GetMapping
    public String test(){
        return testValue;
    }

}
