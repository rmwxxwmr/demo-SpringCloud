package me.chenjd.demo.cloud.alibaba.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author chenjd
 * @date 2022/6/12 10:30
 */
public interface DemoSource {

    @Output("topic-demo-01-output")
    MessageChannel topicDemo01Output();

    @Output("topic-demo-02-output")
    MessageChannel topicDemo02Output();

}
