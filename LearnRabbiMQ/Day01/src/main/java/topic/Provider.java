package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        // 声明topic类型的交换机
        channel.exchangeDeclare("logs_topic", "topic");
        // routeKey
        String routeKey1 = "user.save";
        String routeKey2 = "user.save.findAll";
        // 发送消息
        channel.basicPublish("logs_topic", routeKey1, null, ("这里是topic动态路由模型, routerKey: [" + routeKey1 + "]").getBytes());
        channel.basicPublish("logs_topic", routeKey2, null, ("这里是topic动态路由模型, routerKey: [" + routeKey2 + "]").getBytes());

        RabbitMQUtils.closeConnection(channel, connection);
    }
}
