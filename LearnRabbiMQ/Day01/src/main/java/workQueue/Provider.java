package workQueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        // 获取通道对象
        Channel channel = connection.createChannel();
        // 通过通道对象声明队列
        channel.queueDeclare("workQueue", true, false, false, null);
        for (int i = 0; i < 20; i++) {
            // 生产消息
            channel.basicPublish("", "workQueue", null, (i + "hello workQueue").getBytes());
        }
        RabbitMQUtils.closeConnection(channel, connection);
    }
}
