package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        // 将通道声明指定交换机
        // 参数1：自定义交换机的名称 参数2：交换机的类型 fanout表示广播
        channel.exchangeDeclare("logs", "fanout");
        //发送消息
        channel.basicPublish("logs", "", null, "fanout type message".getBytes());

        RabbitMQUtils.closeConnection(channel, connection);
    }
}
