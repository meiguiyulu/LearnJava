package workQueue;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.basicQos(1);//每一次只能消费一个消息
        channel.queueDeclare("workQueue", true, false, false, null);
        //参数1:队列名称  参数2:消息自动确认 true代表消费者自动向rabbitmq确认消息消费；false代表不会自动确认消息
        channel.basicConsume("workQueue", false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者-1： " + new String(body));
                // 手动确认  参数1:手动确认消息标识  参数2:false 每次确认一个
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
