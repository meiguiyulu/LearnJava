package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare("logs_direct", "direct");
        // 发送消息
        String routingKey = "info";
        channel.basicPublish("logs_direct", routingKey, null, ("这是direct模型发布的基于routeKey: [" + routingKey + "] 发送的消息").getBytes());
        channel.basicPublish("logs_direct", "error", null, ("这是direct模型发布的基于routeKey: [" + "error" + "] 发送的消息").getBytes());

        RabbitMQUtils.closeConnection(channel, connection);
    }
}
