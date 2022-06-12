package me.chenjd.demo.cloud.alibaba.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author chenjd
 * @date 2022/6/12 10:53
 */
public interface DemoSink {

    String TOPIC_DEMO_01_INPUT="topic-demo-01-input";

    String TOPIC_DEMO_02_INPUT="topic-demo-02-input";

    @Input(TOPIC_DEMO_01_INPUT)
    SubscribableChannel topicDemo01Input();

    @Input(TOPIC_DEMO_02_INPUT)
    SubscribableChannel topicDemo02Input();

}
