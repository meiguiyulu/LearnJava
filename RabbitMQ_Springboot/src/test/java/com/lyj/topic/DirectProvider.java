package com.lyj.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectProvider {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs_direct", type = "direct"),
                    key = {"info", "warning"}
            )
    })
    public void receive1(String message) {
        System.out.println("消费者1-info+warning: " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs_direct", type = "direct"),
                    key = {"info", "error", "warning"}
            )
    })
    public void receive2(String message) {
        System.out.println("消费者2-info+error+warning: " + message);
    }
}
