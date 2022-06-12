package me.chenjd.demo.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import me.chenjd.demo.cloud.alibaba.message.DemoSource;
import me.chenjd.demo.cloud.alibaba.message.UserMessage;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2022/6/12 10:38
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    private final DemoSource demoSource;

    public UserController(DemoSource demoSource) {
        this.demoSource = demoSource;
    }

    @GetMapping("send01")
    public boolean send01(){
        UserMessage userMessage = new UserMessage();
        userMessage.setUserId(1);
        userMessage.setUserName("01");
        userMessage.setComment("send01");
        Message<UserMessage> build = MessageBuilder.withPayload(userMessage).build();
        log.info("send message:{}",userMessage);
        return demoSource.topicDemo01Output().send(build);
    }

    @GetMapping("send02")
    public boolean send02(){
        UserMessage userMessage = new UserMessage();
        userMessage.setUserId(2);
        userMessage.setUserName("02");
        userMessage.setComment("send02");
        Message<UserMessage> build = MessageBuilder.withPayload(userMessage).build();
        log.info("send message:{}",userMessage);
        return demoSource.topicDemo01Output().send(build);
    }

    @GetMapping("send01-delay")
    public boolean send01Delay(){
        UserMessage userMessage = new UserMessage();
        userMessage.setUserId(1);
        userMessage.setUserName("01");
        userMessage.setComment("send01-delay");
        Message<UserMessage> build = MessageBuilder.withPayload(userMessage).setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL,"3").build();
        log.info("send message:{}",userMessage);
        return demoSource.topicDemo01Output().send(build);
    }

    @GetMapping("send01-tag")
    public boolean send01Tag(){
        UserMessage userMessage = new UserMessage();
        userMessage.setUserId(1);
        userMessage.setUserName("01");
        userMessage.setComment("send01-tag");
        Message<UserMessage> build = MessageBuilder.withPayload(userMessage).setHeader(MessageConst.PROPERTY_TAGS,"demo_tag").build();
        log.info("send message:{}",userMessage);
        return demoSource.topicDemo01Output().send(build);
    }

}
