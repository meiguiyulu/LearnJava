package com.lyj.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receive1(String message) {
        System.out.println("消费者-1： " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receive2(String message) {
        System.out.println("消费者-2： " + message);
    }

}
