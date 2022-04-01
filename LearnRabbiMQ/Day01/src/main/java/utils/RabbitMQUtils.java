package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory;

    static {
        //创建连接mq的连接工厂对象
        connectionFactory = new ConnectionFactory();
        //设置连接rabbitmq主机
        connectionFactory.setHost("127.0.0.1");
        //设置端口号
        connectionFactory.setPort(5672);
        //设置连接那个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    // 提供连接的方法
    public static Connection getConnection() throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = connectionFactory.newConnection();
        return connection;
    }

    // 关闭通道、关闭连接
    public static void closeConnection(Channel channel, Connection connection) throws IOException, TimeoutException {
        if (channel != null)
            channel.close();
        if (connection != null)
            connection.close();
    }
}
