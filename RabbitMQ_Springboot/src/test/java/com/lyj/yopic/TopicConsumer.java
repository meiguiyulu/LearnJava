package com.lyj.yopic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name="logs_topic", type = "topic"),
                    key = {"user.save", "user.*"}
            )
    })
    public void receive1(String message) {
        System.out.println("消费者1： " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name="logs_topic", type = "topic"),
                    key = {"order.*", "user.*", "produce.*"}
            )
    })
    public void receive2(String message) {
        System.out.println("消费者2： " + message);
    }
}
