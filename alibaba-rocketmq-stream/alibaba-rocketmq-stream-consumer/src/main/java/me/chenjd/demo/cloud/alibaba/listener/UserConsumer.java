package me.chenjd.demo.cloud.alibaba.listener;

import lombok.extern.slf4j.Slf4j;
import me.chenjd.demo.cloud.alibaba.message.DemoSink;
import me.chenjd.demo.cloud.alibaba.message.UserMessage;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author chenjd
 * @date 2022/6/12 10:56
 */
@Component
@Slf4j
public class UserConsumer {

    @StreamListener(DemoSink.TOPIC_DEMO_01_INPUT)
    public void on01Message(@Payload UserMessage message){
        log.info("on01Message:{}",message);
    }

    @StreamListener(DemoSink.TOPIC_DEMO_02_INPUT)
    public void on02Message(@Payload UserMessage message){
        log.info("on02Message:{}",message);
    }

}
