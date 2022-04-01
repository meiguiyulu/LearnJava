package workQueue;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.basicQos(1);//每一次只能消费一个消息
        channel.queueDeclare("workQueue", true, false, false, null);
        //参数1:队列名称  参数2:消息自动确认 true代表消费者自动向rabbitmq确认消息消费；false代表不会自动确认消息
        channel.basicConsume("workQueue", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-2： " + new String(body));
                // 参数1:确认队列中那个具体消息 参数2:是否开启多个消息同时确实
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
